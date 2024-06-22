package com.samyakj820.smart_contact_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    @RequestMapping(value="/profile")
    public String userProfile() {
        return "user/profile";
    }
    
}
