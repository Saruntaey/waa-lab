package edu.miu.waa.lab.service;

import edu.miu.waa.lab.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto u);
    UserDto update(long id, UserDto u);
    UserDto findById(long id);
    List<UserDto> find();
    List<UserDto> findPostGt(int num);
    void delete(long id);
}
