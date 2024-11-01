package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.User;
import edu.miu.waa.lab.entity.dto.UserDto;
import edu.miu.waa.lab.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto create(UserDto input) {
        return modelMapper.map(userRepository.save(modelMapper.map(input, User.class)), UserDto.class);
    }

    @Override
    public UserDto update(long id, UserDto p) {
        User record = userRepository.findById(id).get();
        record.setName(p.getName());
        return modelMapper.map(userRepository.save(record), UserDto.class);
    }

    @Override
    public UserDto findById(long id) {
        User u = userRepository.findById(id).get();
        return modelMapper.map(u, UserDto.class);
    }

    @Override
    public List<UserDto> find() {
        Iterable<User> posts = userRepository.findAll();
        return Streamable.of(posts).map(p -> modelMapper.map(p, UserDto.class)).toList();
    }

    @Override
    public List<UserDto> findPostGt(int num) {
        List<User> users = userRepository.findPostGt(num);
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).toList();
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
