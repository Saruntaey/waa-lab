package edu.miu.waa.lab.controller;

import edu.miu.waa.lab.entity.dto.PostDto;
import edu.miu.waa.lab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PostDto create(@RequestBody PostDto p) {
        return postService.create(p);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto update( @PathVariable("id") long id, @RequestBody PostDto p) {
        return postService.update(id, p);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto findById(@PathVariable("id") long id) {
        return postService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PostDto> find() {
        return postService.find();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") long id) {
        postService.delete(id);
    }
}
