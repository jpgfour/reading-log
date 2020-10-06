package org.launchcode.readinglog.controllers;

import org.launchcode.readinglog.models.Log;
import org.launchcode.readinglog.models.User;
import org.launchcode.readinglog.models.data.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;


@Controller
@RequestMapping("logs")
public class LogController {

//    private void getVolumeDataForLogging(String volumeId) {
//
//        final String uri = "https://www.googleapis.com/books/v1/volumes/" + volumeId;
//        RestTemplate restTemplate = new RestTemplate();
//        Volume result = restTemplate.getForObject(uri,Volume.class);
//        System.out.println(result);
//
//    }

    @Autowired
    private LogRepository logRepository;

    @Autowired
    AuthenticationController authenticationController = null;
    
    public String getVolumeNameAsString(String volumeId) {

        String volumeURL = "https://www.googleapis.com/books/v1/volumes/" + volumeId;

        RestTemplate restTemplate = new RestTemplate();
        String volumeResponse = restTemplate.getForObject(volumeURL, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = springParser.parseMap(volumeResponse);
        System.out.println(map.values());

        String mapArray[] = new String[map.size()];
        System.out.println("Items found: " + mapArray.length);

        String volName = "";

        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            if(entry.getKey() == "volumeInfo") {
//                System.out.println("found volumeInfo key");
//                Object whatAmI = entry.getClass();
//                System.out.println(whatAmI.toString());
                String volumeInfo = entry.toString();
//                System.out.println(volumeInfo);

                Integer startOfTitleIndex = volumeInfo.indexOf("title=") + 6;
                Integer endOfTitleIndex;
                if(volumeInfo.contains("subtitle")) {
                    endOfTitleIndex = volumeInfo.indexOf(", subtitle=");
                    }else endOfTitleIndex = volumeInfo.indexOf(", authors=");
                volName = volumeInfo.substring(startOfTitleIndex, endOfTitleIndex);
            }
            i++;
        }
        return volName;
    }

    public String getCurrentUserNameAsString(){

        HttpSession currentSession = (HttpSession) RequestContextHolder.currentRequestAttributes().getSessionMutex();
        User currentUser = authenticationController.getUserFromSession(currentSession);
        return currentUser.getUsername();
    }




    @RequestMapping("add/{volumeId}")
    public String displayAddLogForm(Model model, @PathVariable String volumeId) {
//        TODO: query API based on ID, pull data points, pass data points to Add template

//        getVolumeDataForLogging(volumeId);

        //model.addAttribute("volumeGoogleId", volumeId);

        model.addAttribute(new Log());

        return "add";
    }

    @PostMapping("add/{volumeId}")
    public String processAddLogForm(@ModelAttribute @Valid Log newLog, Errors errors, Model model, @RequestParam String date,
                                    @RequestParam Integer minutesLogged, @RequestParam int pagesLogged, @PathVariable String volumeId) throws IOException {

        //begin code block get google books response using volumeId from Path
        String volumeName = getVolumeNameAsString(volumeId);
        //end code block get google books response

        newLog.setVolumeName(volumeName);
        newLog.setVolumeGoogleId(volumeId);
        newLog.setUserName(getCurrentUserNameAsString());

        logRepository.save(newLog);

        model.addAttribute("logs",logRepository.findAll());

        return "display";
    }

    //Get or Post?  I think just Get
    @GetMapping ("display")
    public String log(Model model){

        //TODO: build out for individual user display
        //model.addAttribute("userID", userID);

        model.addAttribute("logs",logRepository.findAll());

        return "display";
    }
}

