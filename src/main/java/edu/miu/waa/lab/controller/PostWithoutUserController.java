package edu.miu.waa.lab.controller;

import edu.miu.waa.lab.entity.dto.PostDto;
import edu.miu.waa.lab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostWithoutUserController {
    @Autowired
    PostService postService;

    @GetMapping("/filter/title/{title}")
    List<PostDto> findByTitle(@PathVariable("title") String title) {
        return postService.findByTitle(title);
    }
}
