package com.codeup.codeupblog.exercises;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //defines that our class is a controller
public class HelloWorldController {
    @GetMapping("/hello/{name}/{last_name}") //defines a method that should be invoked when a GET request is received for the specified URI
    @ResponseBody //tells Spring that whatever is returned from this method should be the body of our response
    public String sayHello(@PathVariable String name, @PathVariable String last_name) {
        return "Hello, " + name + " " + last_name;
    } //you can also have multiple path variables on a method

    @GetMapping("/logout")
    @ResponseBody
    public String logout() {
        return "You have been logged out!";
    }

    @RequestMapping(path = "/lights", method = RequestMethod.GET) //the @GetMapping is easier to remember, this is just the longer version of @GetMapping
    @ResponseBody
    public String lights() {
        return "lights On";
    }

    @GetMapping("/increment/{number}")
    @ResponseBody
    public String addOne(@PathVariable int number) { //you can define the Path Variable with with a type other than String
        return number + " plus one is " + (number + 1) + "!";
    }
}
