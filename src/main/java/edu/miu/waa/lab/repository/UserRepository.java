package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query( "select u from User u where size(u.posts) >= :num" )
    public List<User> findPostGt(int num);
    Optional<User> findByName(String name);
}
