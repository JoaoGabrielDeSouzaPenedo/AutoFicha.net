package br.com.autoficha.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dons")
public class Dom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @Column(nullable = false, length = 150)
    private String nome;

    private Integer atual = 0;

    private Integer maximo = 0;

    private Integer custo = 0;

    public Dom() {
    }

    public Long getId() {
        return id;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAtual() {
        return atual;
    }

    public void setAtual(Integer atual) {
        this.atual = atual;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }
}