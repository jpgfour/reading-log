package org.launchcode.readinglog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @Autowired
//    AuthenticationController authenticationController;
    //HttpServletRequest request;
//    HttpSession session = request.getSession();
//    User user = authenticationController.getUserFromSession(session);

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        //return "Hello" + request.getRemoteUser() + ".  Welcome to the plaintext reading log.  More features coming soon.";
        return "Hello" + " World" + ".  Welcome to the plaintext reading log.  More features coming soon.";
    }

    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye.  Come back soon.";
    }

}
