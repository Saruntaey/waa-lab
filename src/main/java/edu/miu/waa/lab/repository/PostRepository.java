package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository  extends CrudRepository<Post, Long> {
   List<Post> findPostByTitle(String title);
}
