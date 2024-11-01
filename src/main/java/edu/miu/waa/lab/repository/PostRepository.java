package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository  extends CrudRepository<Post, Long> {
}
