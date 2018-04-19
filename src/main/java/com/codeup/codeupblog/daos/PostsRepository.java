package com.codeup.codeupblog.daos;

import com.codeup.codeupblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Long> {

}
