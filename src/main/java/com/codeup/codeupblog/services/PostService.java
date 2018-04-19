package com.codeup.codeupblog.services;

import com.codeup.codeupblog.daos.PostsRepository;
import com.codeup.codeupblog.models.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostsRepository postsDao;

    public PostService(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }

    public Iterable<Post> getAllPosts() {
        return postsDao.findAll();
    }

    public Post getPost(long id) {
        return postsDao.findOne(id);
    }

    public Post save(Post post) {
        postsDao.save(post);
        return postsDao.findOne(post.getId());
    }

    public void delete(long id) {
        postsDao.delete(id);
    }
}
