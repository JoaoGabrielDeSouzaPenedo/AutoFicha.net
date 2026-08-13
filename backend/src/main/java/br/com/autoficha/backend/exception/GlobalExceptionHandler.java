package br.com.autoficha.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameJaExisteException.class)
    public ResponseEntity<ErroResponse> tratarUsernameJaExiste(
            UsernameJaExisteException exception
    ) {

        ErroResponse erro = new ErroResponse(
                HttpStatus.CONFLICT.value(),
                "Usuário já cadastrado",
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> tratarValidacao(
            MethodArgumentNotValidException exception
    ) {

        Map<String, String> campos = new LinkedHashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError ->
                        campos.put(
                                fieldError.getField(),
                                fieldError.getDefaultMessage()
                        )
                );

        ErroResponse erro = new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Dados inválidos",
                "Existem campos inválidos na requisição",
                campos
        );

        return ResponseEntity
                .badRequest()
                .body(erro);
    }
}