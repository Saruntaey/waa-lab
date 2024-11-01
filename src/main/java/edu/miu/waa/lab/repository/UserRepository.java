package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
