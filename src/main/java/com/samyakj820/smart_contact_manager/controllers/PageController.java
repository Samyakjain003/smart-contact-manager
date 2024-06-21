package com.samyakj820.smart_contact_manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samyakj820.smart_contact_manager.entities.User;
import com.samyakj820.smart_contact_manager.forms.UserForm;
import com.samyakj820.smart_contact_manager.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String registerPage(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("Processing Registration");
        // fetching form data, validation, save to db
        // System.out.println(userForm);

        User user = User.builder()
            .name(userForm.getName())
            .email(userForm.getEmail())
            .password(userForm.getPassword())
            .phoneNumber(userForm.getPhoneNumber())
            .about(userForm.getAbout())
            .profilePic("https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436188.jpg?size=626&ext=jpg&ga=GA1.1.1567401352.1716903950&semt=ais_user")
            .build();

        userService.saveUser(user);
        System.out.println("User saved!!");


        return "redirect:/register";
    }
}
