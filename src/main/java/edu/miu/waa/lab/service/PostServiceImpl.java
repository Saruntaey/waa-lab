package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.Post;
import edu.miu.waa.lab.entity.User;
import edu.miu.waa.lab.entity.dto.PostDto;
import edu.miu.waa.lab.repository.PostRepository;
import edu.miu.waa.lab.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public PostDto create(PostDto input, long userId) {
        User u = userRepository.findById(userId).get();
        Post p = modelMapper.map(input, Post.class);
        u.addPost(p);
        p = postRepository.save(p);
        return postToDto(p, u);
    }

    @Override
    public PostDto update(long id, PostDto p, long userId) {
        User user = userRepository.findById(userId).get();
//        Post record = postRepository.findById(id).get();
        Post record = user.getPost(id);
        record.setTitle(p.getTitle());
        record.setContent(p.getContent());
        postRepository.save(record);
        return postToDto(record, user);
    }

    @Override
    public PostDto findById(long id, long userId) {
        User u = userRepository.findById(userId).get();
        Post p = u.getPost(id);
        return postToDto(p, u);
    }

    @Override
    public List<PostDto> find(long userId) {
        User u = userRepository.findById(userId).get();
        return u.getPosts().stream().map(p -> postToDto(p, u)).toList();
    }

    @Override
    public List<PostDto> findByTitle(String title) {
        List<Post> posts = postRepository.findPostByTitle(title);
        // TODO: resolve author
        return posts.stream().map(p -> postToDto(p, new User())).toList();
    }

    @Override
    public void delete(long id, long userId) {
        User u = userRepository.findById(userId).get();
        postRepository.deleteById(id);
    }

    private PostDto postToDto(Post p, User u) {
        PostDto out = modelMapper.map(p, PostDto.class);
        out.setAuthor(u.getName());
        return out;
    }
}
