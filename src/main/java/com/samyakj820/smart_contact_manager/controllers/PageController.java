package com.samyakj820.smart_contact_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("Home page Handler");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading");
        return "services";
    }

    @RequestMapping("/contact")
    public String contactPage() {
        System.out.println("Contact page loading");
        return "contact";
    }

    @RequestMapping("/login")
    public String loginPage() {
        System.out.println("Login page loading");
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage() {
        System.out.println("Register page loading");
        return "register";
    }
}
