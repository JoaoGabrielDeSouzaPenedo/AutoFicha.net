package br.com.autoficha.backend.exception;

public class PersonagemNaoEncontradoException extends RuntimeException {

    public PersonagemNaoEncontradoException(Long id) {
        super("Personagem de id " + id + " não foi encontrado");
    }
}