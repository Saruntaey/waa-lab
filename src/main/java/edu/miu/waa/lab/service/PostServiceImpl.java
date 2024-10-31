package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.Post;
import edu.miu.waa.lab.entity.dto.PostDto;
import edu.miu.waa.lab.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepository postRepository;

    @Override
    public PostDto create(PostDto input) {
        Post p = modelMapper.map(input, Post.class);
        p = postRepository.store(p);
        return modelMapper.map(p, PostDto.class);
    }

    @Override
    public PostDto update(long id, PostDto p) {
        Post record = postRepository.findById(id);
        record.setTitle(p.getTitle());
        record.setAuthor(p.getAuthor());
        record.setContent(p.getContent());
        return modelMapper.map(postRepository.store(record), PostDto.class);
    }

    @Override
    public PostDto findById(long id) {
        Post p = postRepository.findById(id);
        return modelMapper.map(p, PostDto.class);
    }

    @Override
    public List<PostDto> find() {
        List<Post> posts = postRepository.find();
        return posts.stream().map(p -> modelMapper.map(p, PostDto.class)).toList();
    }

    @Override
    public void delete(long id) {
        postRepository.delete(id);
    }
}
