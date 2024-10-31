package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto create(PostDto p);
    PostDto update(long id, PostDto p);
    PostDto findById(long id);
    List<PostDto> find();
    void delete(long id);
}
