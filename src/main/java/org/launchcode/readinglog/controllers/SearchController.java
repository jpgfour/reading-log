package org.launchcode.readinglog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping("")
    public String search(Model model) {
        //model.addAttribute();
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchTerm){

        model.addAttribute("searchTerm", searchTerm);

        return "results";
    }
}
