package com.app.mongodb.repository;

import com.app.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
    Utilizada para persistir no banco de dados.
*/
@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
