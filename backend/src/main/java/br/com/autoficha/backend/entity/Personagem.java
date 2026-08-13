package br.com.autoficha.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "personagens")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    private String jogador;

    private Integer nivel = 1;

    private Integer experiencia = 0;

    private Integer pontosVidaAtual;

    private Integer pontosVidaMaximo;

    private Integer pontosEnergiaAtual;

    private Integer pontosEnergiaMaximo;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Personagem() {
    }

    public Personagem(String nome, String jogador, Usuario usuario) {
        this.nome = nome;
        this.jogador = jogador;
        this.usuario = usuario;
        this.nivel = 1;
        this.experiencia = 0;
    }

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
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

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public Integer getPontosVidaAtual() {
        return pontosVidaAtual;
    }

    public void setPontosVidaAtual(Integer pontosVidaAtual) {
        this.pontosVidaAtual = pontosVidaAtual;
    }

    public Integer getPontosVidaMaximo() {
        return pontosVidaMaximo;
    }

    public void setPontosVidaMaximo(Integer pontosVidaMaximo) {
        this.pontosVidaMaximo = pontosVidaMaximo;
    }

    public Integer getPontosEnergiaAtual() {
        return pontosEnergiaAtual;
    }

    public void setPontosEnergiaAtual(Integer pontosEnergiaAtual) {
        this.pontosEnergiaAtual = pontosEnergiaAtual;
    }

    public Integer getPontosEnergiaMaximo() {
        return pontosEnergiaMaximo;
    }

    public void setPontosEnergiaMaximo(Integer pontosEnergiaMaximo) {
        this.pontosEnergiaMaximo = pontosEnergiaMaximo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}