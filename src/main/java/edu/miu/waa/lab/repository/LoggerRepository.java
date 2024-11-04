package edu.miu.waa.lab.repository;

import edu.miu.waa.lab.entity.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepository extends CrudRepository<Logger, Long> {
}
