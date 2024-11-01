package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto create(CommentDto comment, long userId, long postId);
    List<CommentDto> find(long userId, long postId);
}
