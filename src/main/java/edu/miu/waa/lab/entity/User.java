package edu.miu.waa.lab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public void addPost(Post p) {
        posts.add(p);
    }

    public Post getPost(long id) {
        return posts.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public void addRole(Role r) {
        roles.add(r);
    }
}
