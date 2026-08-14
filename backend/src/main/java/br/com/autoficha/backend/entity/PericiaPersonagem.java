package br.com.autoficha.backend.entity;

import br.com.autoficha.backend.enums.AtributoBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "pericias_personagem")
public class PericiaPersonagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @Column(nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    private AtributoBase atributoBase;

    private Integer outros = 0;

    private Boolean treinada = false;

    private Boolean maestria = false;

    private Integer total = 0;

    public PericiaPersonagem() {
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

    public AtributoBase getAtributoBase() {
        return atributoBase;
    }

    public void setAtributoBase(AtributoBase atributoBase) {
        this.atributoBase = atributoBase;
    }

    public Integer getOutros() {
        return outros;
    }

    public void setOutros(Integer outros) {
        this.outros = outros;
    }

    public Boolean getTreinada() {
        return treinada;
    }

    public void setTreinada(Boolean treinada) {
        this.treinada = treinada;
    }

    public Boolean getMaestria() {
        return maestria;
    }

    public void setMaestria(Boolean maestria) {
        this.maestria = maestria;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}