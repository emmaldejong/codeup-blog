package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.models.Post;
import com.codeup.codeupblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/posts")
    public String index(@PathVariable PostService postService, Model model) {

        List<Post> posts = new ArrayList<>();

        posts.add(new Post("Post Title 1", "This is a description of post 1."));
        posts.add(new Post("Post Title 2", "This is a description of post 2."));
        posts.add(new Post("Post Title 3", "This is a description of post 3."));
        posts.add(new Post("Post Title 4", "This is a description of post 4."));

        model.addAttribute("posts", posts);
        PostService postService1 = (PostService) postService.findAll();
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post = new Post("Test Post", "This is a test description.");
        model.addAttribute("post", post);
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
