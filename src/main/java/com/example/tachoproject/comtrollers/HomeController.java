package com.example.tachoproject.comtrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")  // Handles requests for the root path
    public String home(){
        return "home";    //returns view name
    }
}
