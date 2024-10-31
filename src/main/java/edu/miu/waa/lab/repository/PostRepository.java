package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.Post;

import java.util.List;

public interface PostRepository {
    Post store(Post p);
    void delete(long id);
    Post findById(long id);
    List<Post> find();
}
