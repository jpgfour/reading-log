package org.launchcode.readinglog.controllers;

import org.launchcode.readinglog.models.Log;
import org.launchcode.readinglog.models.data.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

        model.addAttribute("volumeId", volumeId);

        model.addAttribute(new Log());

        return "add";
    }

    @PostMapping("add/{volumeId}")
    public String processAddLogForm(@ModelAttribute @Valid Log newLog, Errors errors, Model model, @RequestParam String date,
                                    @RequestParam Integer minutesLogged, @RequestParam int pagesLogged) {

        logRepository.save(newLog);

        return "display";
    }

    //Get or Post?  I think just Get
    @GetMapping ("display")
    public String log(Model model, @RequestParam int userID){

        model.addAttribute("userID", userID);

        return "display";
    }
}

