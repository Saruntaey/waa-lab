package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
