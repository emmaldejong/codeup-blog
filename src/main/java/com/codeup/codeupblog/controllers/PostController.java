package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    PostService postSvc;

    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postSvc.getAllPosts());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.getPost(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "Here is the post create form...";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "Inserted new post!";
    }

}