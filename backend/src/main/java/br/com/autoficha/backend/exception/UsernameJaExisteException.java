package br.com.autoficha.backend.exception;

public class UsernameJaExisteException extends RuntimeException {

    public UsernameJaExisteException(String username) {
        super("O usuário '" + username + "' já está cadastrado");
    }
}