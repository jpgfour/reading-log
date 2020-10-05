package org.launchcode.readinglog.controllers;

import org.launchcode.readinglog.models.Log;
import org.launchcode.readinglog.models.data.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @RequestMapping("add/{volumeId}")
    public String displayAddLogForm(Model model, @PathVariable String volumeId) {
//        TODO: query API based on ID, pull data points, pass data points to Add template

//        getVolumeDataForLogging(volumeId);

        model.addAttribute("volumeGoogleId", volumeId);

        model.addAttribute(new Log());

        return "add";
    }

    @PostMapping("add/{volumeId}")
    public String processAddLogForm(@ModelAttribute @Valid Log newLog, Errors errors, Model model, @RequestParam String volumeGoogleId, @RequestParam String volumeName, @RequestParam String date,
                                    @RequestParam Integer minutesLogged, @RequestParam int pagesLogged, @PathVariable String volumeId) throws IOException {

        //begin code block get google books response using volumeId from Path

        String volumeURL = "https://www.googleapis.com/books/v1/volumes/" + volumeId;
        RestTemplate restTemplate = new RestTemplate();
        String volumeResponse = restTemplate.getForObject(volumeURL, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = springParser.parseMap(volumeResponse);
        System.out.println(map.values());

        String mapArray[] = new String[map.size()];
        System.out.println("Items found: " + mapArray.length);


        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            if(entry.getKey() == "volumeInfo") {
                System.out.println("found volumeInfo key");
                Object whatAmI = entry.getClass();
                System.out.println(whatAmI.toString());
                String volumeInfo = entry.toString();
                System.out.println(volumeInfo);

            }
            i++;
        }

        //end code block get google books response


        newLog.setVolumeGoogleId(volumeId);

        logRepository.save(newLog);

        model.addAttribute("logs",logRepository.findAll());

        return "display";
    }

    //Get or Post?  I think just Get
    @GetMapping ("display")
    public String log(Model model, @RequestParam int userID){

        model.addAttribute("userID", userID);

        return "display";
    }
}

