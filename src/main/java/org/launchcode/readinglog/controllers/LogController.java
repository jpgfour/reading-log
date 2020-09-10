package org.launchcode.readinglog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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



    @RequestMapping("add/{volumeId}")
    public String log(Model model, @PathVariable String volumeId) {
//        TODO: query API based on ID, pull data points, pass data points to Add template

//        getVolumeDataForLogging(volumeId);

        model.addAttribute("volumeId", volumeId);
        return "add";
    }


    @PostMapping("display")
    public String log(Model model, @RequestParam int userID){

        model.addAttribute("userID", userID);

        return "display";
    }
}
