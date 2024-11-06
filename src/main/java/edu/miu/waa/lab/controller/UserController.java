package edu.miu.waa.lab.controller;

import edu.miu.waa.lab.aspect.annotation.ExecutionTime;
import edu.miu.waa.lab.entity.Role;
import edu.miu.waa.lab.entity.dto.UserDto;
import edu.miu.waa.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto create(@RequestBody UserDto u) {
        return userService.create(u);
    }

    @PostMapping("/{id}")
    UserDto update(@PathVariable("id") long id,@RequestBody UserDto u) {
        return userService.update(id, u);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    UserDto findById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @GetMapping
    List<UserDto> find() {
        return userService.find();
    }

    @GetMapping("/filter/post-gt/{num}")
    List<UserDto> findPostGt(@PathVariable("num") int num) {
        return userService.findPostGt(num);
    }

    @PostMapping("/{id}/roles/{roleId}")
    UserDto addRole(@PathVariable("id") long id, @PathVariable("roleId") long roleId) {
        return userService.addRole(id, roleId);
    }

    @PostMapping("/roles")
    Role crateRole (@RequestBody Role role) {
        return userService.createRole(role);
    }

    @GetMapping("/roles")
    List<Role> findRole() {
        return userService.findRole();
    }
}
