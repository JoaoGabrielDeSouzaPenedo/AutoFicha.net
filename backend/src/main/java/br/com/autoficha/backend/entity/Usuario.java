package br.com.autoficha.backend.entity;

import br.com.autoficha.backend.enums.RoleUsuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleUsuario role;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    public Usuario() {
    }

    public Usuario(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.role = RoleUsuario.USER;
    }

    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = RoleUsuario.USER;
        }

        if (dataCriacao == null) {
            dataCriacao = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RoleUsuario getRole() {
        return role;
    }

    public void setRole(RoleUsuario role) {
        this.role = role;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}