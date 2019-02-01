package com.app.mongodb.services;

import com.app.mongodb.domain.User;
import com.app.mongodb.repository.UserRepository;
import com.app.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/*
    Implementação dos métodos e regras de negócio
*/
@Service
public class UserService implements Serializable {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
