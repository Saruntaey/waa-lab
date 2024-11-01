package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.Comment;
import edu.miu.waa.lab.entity.Post;
import edu.miu.waa.lab.entity.User;
import edu.miu.waa.lab.entity.dto.CommentDto;
import edu.miu.waa.lab.repository.CommentRepository;
import edu.miu.waa.lab.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CommentDto create(CommentDto commentDto, long userId, long postId) {
        User user = userRepository.findById(userId).get();
        Post post = user.getPost(postId);
        Comment comment = modelMapper.map(commentDto, Comment.class);
        post.addComment(comment);
        return modelMapper.map(commentRepository.save(comment), CommentDto.class);
    }

    @Override
    public List<CommentDto> find(long userId, long postId) {
        User user = userRepository.findById(userId).get();
        Post post = user.getPost(postId);
        List<Comment> comments = post.getComments();
        return comments.stream().map(c -> modelMapper.map(c, CommentDto.class)).toList();
    }
}
