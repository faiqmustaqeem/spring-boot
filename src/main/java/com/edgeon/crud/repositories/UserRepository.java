package com.edgeon.crud.repositories;

import com.edgeon.crud.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {

    @Query
     Optional<UserModel> findById(String id);

    UserModel findByEmail(String email);
    UserModel findByCity(String city);

    List<UserModel> findByAgeLessThan(int age);
}
