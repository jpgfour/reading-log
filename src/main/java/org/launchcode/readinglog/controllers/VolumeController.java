package org.launchcode.readinglog.controllers;

import org.launchcode.readinglog.models.Volume;
import org.launchcode.readinglog.models.data.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("volumes")

//TODO: is this even necessary?  can't volumeId just be a field of the log?
//TODO: implement this to create/save Volumes which hold Logs
//TODO: figure out oif volumeID replaces unique ID

public class VolumeController {

    @Autowired
    private VolumeRepository volumeRepository;

    @RequestMapping("add/{volumeId}")
    public String displayAddVolumeForm(Model model, @PathVariable String volumeId, String title, String authors, Integer pageCount) {
//        TODO: query API based on ID, pull data points, pass data points to Add template

//        getVolumeDataForLogging(googleBooksId);

        model.addAttribute("volumeId", volumeId);
        return "add";
    }

    @PostMapping("add/{volumeId}")
    public String processAddVolumeForm(@ModelAttribute @Valid Volume newVolume, Errors errors, Model model, @RequestParam String volumeId,
                                       @RequestParam String title, @RequestParam String authors, @RequestParam Integer pageCount) {
        return "display";
    }

    //Get or Post?  I think just Get
    @GetMapping ("display")
    public String log(Model model, @RequestParam int userID){

        model.addAttribute("userID", userID);

        return "display";
    }

}
