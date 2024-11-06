package edu.miu.waa.lab.entity.dto;

import edu.miu.waa.lab.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private long id;
    private String name;
    private String password;
    private List<Role> roles;
}
