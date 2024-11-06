package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.Role;
import edu.miu.waa.lab.entity.User;
import edu.miu.waa.lab.entity.dto.LoginRequest;
import edu.miu.waa.lab.entity.dto.LoginResponse;
import edu.miu.waa.lab.entity.dto.UserDto;
import edu.miu.waa.lab.repository.RoleRepository;
import edu.miu.waa.lab.repository.UserRepository;
import edu.miu.waa.lab.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDto create(UserDto input) {
        User u = modelMapper.map(input, User.class);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return modelMapper.map(userRepository.save(u), UserDto.class);
    }

    @Override
    public UserDto update(long id, UserDto p) {
        User record = userRepository.findById(id).get();
        record.setName(p.getName());
        return modelMapper.map(userRepository.save(record), UserDto.class);
    }

    @Override
    public UserDto addRole(long id, long roleId) {
        User u = userRepository.findById(id).get();
        Role r = roleRepository.findById(roleId).get();
        u.addRole(r);
        return modelMapper.map(userRepository.save(u), UserDto.class);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User u = userRepository.findByName(loginRequest.getUsername()).get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), u.getPassword())) {
            throw new RuntimeException("password not match");
        }
        String token = jwtUtil.generateToken(u);
        LoginResponse out = new LoginResponse();
        out.setToken(token);
        return out;
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

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findRole() {
        return Streamable.of(roleRepository.findAll()).toList();
    }
}
