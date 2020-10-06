package org.launchcode.readinglog.controllers;

import org.launchcode.readinglog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @Autowired
    AuthenticationController authenticationController;

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {

        HttpSession currentSession = (HttpSession) RequestContextHolder.currentRequestAttributes().getSessionMutex();
        final User currentUser = authenticationController.getUserFromSession(currentSession);

        return "Hello  <b>" + currentUser.getUsername() + "!</b>  Welcome to the plaintext reading log.  More features coming soon."
                + "<br><br>" + "<a href=/search>Search for a book</a>" ;
    }

    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye.  Come back soon.";
    }

}
