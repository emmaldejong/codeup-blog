package com.codeup.codeupblog.services;

import com.codeup.codeupblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(long id) {
        return posts.get((int) (id - 1));
    }

    private void createPosts() {
        posts.add(new Post("Test Post 1", "test description 1"));
        posts.add(new Post("Test Post 2", "test description 2"));
        posts.add(new Post("Test Post 3", "test description 3"));
    }

    public void save(Post post) {
        this.posts.add(post);
    }
}
