package edu.miu.waa.lab.controller;

import edu.miu.waa.lab.entity.dto.CommentDto;
import edu.miu.waa.lab.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/posts/{postId}/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping
    CommentDto create(@RequestBody CommentDto comment, @PathVariable("userId") long userId, @PathVariable("postId") long postId) {
        return commentService.create(comment, userId, postId);
    }

    @GetMapping
    List<CommentDto> find(@PathVariable("userId") long userId, @PathVariable("postId") long postId) {
        return commentService.find(userId, postId);
    }
}
