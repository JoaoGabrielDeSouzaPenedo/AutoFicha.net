package br.com.autoficha.backend.dto.auth;

import br.com.autoficha.backend.entity.Usuario;
import br.com.autoficha.backend.enums.RoleUsuario;

import java.time.LocalDateTime;

public class UsuarioResponse {

    private Long id;
    private String nome;
    private String username;
    private RoleUsuario role;
    private LocalDateTime dataCriacao;

    public UsuarioResponse() {
    }

    public UsuarioResponse(
            Long id,
            String nome,
            String username,
            RoleUsuario role,
            LocalDateTime dataCriacao
    ) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.role = role;
        this.dataCriacao = dataCriacao;
    }

    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getRole(),
                usuario.getDataCriacao()
        );
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public RoleUsuario getRole() {
        return role;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}