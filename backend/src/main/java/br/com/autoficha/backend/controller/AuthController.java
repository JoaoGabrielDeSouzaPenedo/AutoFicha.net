package br.com.autoficha.backend.controller;

import br.com.autoficha.backend.dto.auth.CadastroRequest;
import br.com.autoficha.backend.dto.auth.UsuarioResponse;
import br.com.autoficha.backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> cadastrar(
            @Valid @RequestBody CadastroRequest request
    ) {

        UsuarioResponse usuario =
                usuarioService.cadastrar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuario);
    }
}