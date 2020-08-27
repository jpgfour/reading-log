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
//    HttpServletRequest request;
//    HttpSession session = request.getSession();
//    User user = authenticationController.getUserFromSession(session);

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {

        //System.out.println(user.getUsername());
        HttpSession currentSession = (HttpSession) RequestContextHolder.currentRequestAttributes().getSessionMutex();
        //String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        final User currentUser = authenticationController.getUserFromSession(currentSession);


        return "Hello " + currentUser.getUsername() + "!  Welcome to the plaintext reading log.  More features coming soon.";
        //return "Hello" + " World" + ".  Welcome to the plaintext reading log.  More features coming soon.";
    }

    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye.  Come back soon.";
    }

    @RequestMapping(value = "harry")
    public String harry() { return "harryPotterExample"; }

    @RequestMapping(value = "mbs")
    public String mbs() { return "searchExample"; }

}
