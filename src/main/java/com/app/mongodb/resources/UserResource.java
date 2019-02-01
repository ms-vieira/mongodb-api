package com.app.mongodb.resources;

import com.app.mongodb.domain.User;
import com.app.mongodb.dto.UserDTO;
import com.app.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    //Para retornar todos os usuários
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        //Retorna 200
        return ResponseEntity.ok().body(listDto);
    }

    //Para retornar aquele usuário passado na requisição
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        //Retorna 200
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    //Para inserir user
    @RequestMapping(method = RequestMethod.POST)
    /*  Resquest ou Postmaping
    **  Para aceitar um obj é preciso colocar RequestBody
    **  Retorna um obj vazio(Void)
    */
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        //Converte o DTO para User
        User obj = service.fromDTO(objDto);
        //Insere o user
        obj = service.insert(obj);
        // Para retornar o obj inserido, passamos por parametro o id do obj
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        //Retorna o código 201
        return ResponseEntity.created(uri).build();
    }

    //Para deletar um user
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        //Retorna 204
        return ResponseEntity.noContent().build();
    }

    //Atualizar o user
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromDTO(objDto);
        //Seta o id passado no parametro
        obj.setId(id);
        //Chama o método para atualizar
        obj = service.update(obj);
        //Retorna 204
        return ResponseEntity.noContent().build();
    }

}