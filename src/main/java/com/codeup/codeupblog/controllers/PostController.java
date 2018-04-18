package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.models.Post;
import com.codeup.codeupblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showCreateForm(Model model) {
        model.addAttribute("newPost", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost) {
        postSvc.save(newPost);
        return "redirect:/posts";
    }
}