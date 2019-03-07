package com.edgeon.crud.repositories;

import com.edgeon.crud.models.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<TaskModel, String> {

}
