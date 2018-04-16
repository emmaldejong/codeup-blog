package com.codeup.codeupblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/addition/{x}/{y}")
    @ResponseBody
    public String addition(@PathVariable int x, @PathVariable int y) {
        return x + " + " + y + " is " + (x + y);
    }
    @GetMapping("/subtract/{x}/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y) {
        return x + " minus " + y + " equals " + (x - y);
    }
    @GetMapping("/multiply/{x}/{y}")
    @ResponseBody
    public String multiply(@PathVariable int x, @PathVariable int y) {
        return x + " times " + y + " is " + (x * y);
    }
    @GetMapping("/divide/{x}/{y}")
    @ResponseBody
    public String divide(@PathVariable int x, @PathVariable int y) {
        return x + " divided by " + y + " equals " + (x/y);
    }
}
