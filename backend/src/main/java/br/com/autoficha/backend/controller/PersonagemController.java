package br.com.autoficha.backend.controller;

import br.com.autoficha.backend.dto.personagem.AtualizarPersonagemRequest;
import br.com.autoficha.backend.dto.personagem.CriarPersonagemRequest;
import br.com.autoficha.backend.dto.personagem.PersonagemResumoResponse;
import br.com.autoficha.backend.service.PersonagemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    private final PersonagemService personagemService;

    public PersonagemController(
            PersonagemService personagemService
    ) {
        this.personagemService = personagemService;
    }

    @PostMapping
    public ResponseEntity<PersonagemResumoResponse> criar(
            @Valid @RequestBody CriarPersonagemRequest request,
            Authentication authentication
    ) {

        PersonagemResumoResponse personagem =
                personagemService.criar(
                        request,
                        authentication.getName()
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personagem);
    }

    @GetMapping
    public ResponseEntity<List<PersonagemResumoResponse>> listar(
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                personagemService.listar(
                        authentication.getName()
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemResumoResponse> atualizar(
            @PathVariable Long id,
            @RequestBody AtualizarPersonagemRequest request,
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                personagemService.atualizar(
                        id,
                        request,
                        authentication.getName()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id,
            Authentication authentication
    ) {

        personagemService.excluir(
                id,
                authentication.getName()
        );

        return ResponseEntity.noContent().build();
    }
}