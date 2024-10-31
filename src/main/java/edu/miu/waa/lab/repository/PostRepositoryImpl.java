package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository{
    private static long id = 1;
    List<Post> posts = new ArrayList<>();

    @Override
    public Post store(Post p) {
        if (p.getId() == 0) {
            return insert(p);
        }
        return update(p);
    }

    @Override
    public void delete(long id) {
        posts = posts.stream().filter(p -> p.getId() != id).toList();
    }

    @Override
    public Post findById(long id) {
        return posts.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Post> find() {
        return posts;
    }

    private Post insert(Post p) {
        p.setId(id++);
        posts.add(p);
        return p;
    }

    private Post update(Post p) {
        // TODO
        return p;
    }
}
