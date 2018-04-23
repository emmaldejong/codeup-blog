package com.codeup.codeupblog.controllers;

import com.codeup.codeupblog.daos.CategoriesRepository;
import com.codeup.codeupblog.daos.PostsRepository;
import com.codeup.codeupblog.daos.UserRepository;
import com.codeup.codeupblog.models.Categories;
import com.codeup.codeupblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostsRepository postsDao;
    private final UserRepository usersDao;
    private final CategoriesRepository catDao;

    public PostController(PostsRepository postsDao, UserRepository usersDao, CategoriesRepository catDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.catDao = catDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        Iterable<Categories> categories = catDao.findAll();
        model.addAttribute("newPost", new Post());
        model.addAttribute("categories", categories);
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost) {
        newPost.setOwner(usersDao.findOne(1L));
        postsDao.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Iterable<Categories> categories = catDao.findAll();
        model.addAttribute("post", postsDao.findOne(id));
        model.addAttribute("categories", categories);
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post editPost) {
        Post e = postsDao.findOne(editPost.getId());
        e.setTitle(editPost.getTitle());
        e.setBody(editPost.getBody());
        postsDao.save(e);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postsDao.delete(id);
        return "redirect:/posts";
    }
}