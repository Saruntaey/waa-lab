package edu.miu.waa.lab.controller;

import edu.miu.waa.lab.entity.dto.PostDto;
import edu.miu.waa.lab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PostDto create(@RequestBody PostDto p, @PathVariable("userId") long userId) {
        return postService.create(p, userId);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto update(@PathVariable("id") long id, @RequestBody PostDto p, @PathVariable("userId") long userId) {
        return postService.update(id, p, userId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto findById(@PathVariable("id") long id, @PathVariable("userId") long userId) {
        return postService.findById(id, userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PostDto> find(@PathVariable("userId") long userId) {
        return postService.find(userId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") long id, @PathVariable("userId") long userId) {
        postService.delete(id, userId);
    }
}
