package org.hizam.repository;

import org.hizam.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {

}
