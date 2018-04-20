package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
//    @GetMapping("/")
//    @ResponseBody
//    public String welcome() {
//        return "This is the landing page!";
//    }


// ################# using views instead of response body ###################
    @GetMapping("/")
    public String welcome() {
        return "hello";
    }
    @GetMapping("/hello/{name}")
    public String welcomeUser(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
