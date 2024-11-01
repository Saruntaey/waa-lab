package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto create(PostDto p, long userId);
    PostDto update(long id, PostDto p, long userId);
    PostDto findById(long id, long userId);
    List<PostDto> find(long userId);
    void delete(long id, long userId);
}
