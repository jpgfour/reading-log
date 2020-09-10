package org.launchcode.readinglog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("logs")
public class LogController {

    @RequestMapping("add")
    public String log(Model model) {
        //model.addAttribute();
        return "add";
    }

    @PostMapping("display")
    public String log(Model model, @RequestParam int userID){

        model.addAttribute("userID", userID);

        return "display";
    }
}
