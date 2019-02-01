package com.app.mongodb.services;

import com.app.mongodb.domain.User;
import com.app.mongodb.dto.UserDTO;
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

    //Buscar todos os users
    public List<User> findAll() {
        return repo.findAll();
    }

    //Buscar user especifíco
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //Inserir user
    public User insert(User obj) {
        return repo.insert(obj);
    }

    //Deletar um user
    public void delete(String id) {
        //Procura o id, caso não encontre já retorna a exceção
        findById(id);
        repo.deleteById(id);
    }

    //Copia os dados do obj para o newobj
    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    //Para atualizar user
    public User update (User obj) {
        //Buscando no bd o objeto a ser atualizado
        User newObj = findById(obj.getId());
        //Copia os dados do obj para o newobj
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    //Pega um DTO e instancia um user
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
