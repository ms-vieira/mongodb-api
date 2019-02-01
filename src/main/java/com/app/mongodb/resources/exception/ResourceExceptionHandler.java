package com.app.mongodb.resources.exception;

import com.app.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

//Responsavel por tratar possiveis erros nas resquisições
@ControllerAdvice
public class ResourceExceptionHandler {

    //Para mapear quando ocorrer essa exceção, fazer o tratamento abaixo
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        //Armazena o valor do Not Found
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(
                System.currentTimeMillis(), //Data e hora
                status.value(),             //Converte o notfound para número
                "Não encontrado",     //descrição da nossa mensagem
                e.getMessage(),             //mensagem capturada pela exception
                request.getRequestURI());   //captura o caminho que gerou a exceção

        return ResponseEntity.status(status).body(err);
    }


}
