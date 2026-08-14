package br.com.autoficha.backend.entity;

import br.com.autoficha.backend.enums.EstadoAlma;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "recursos")
public class Recursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id", nullable = false, unique = true)
    private Personagem personagem;

    private Integer pvAtual = 0;
    private Integer pvMaximo = 0;
    private Integer pvTemporario = 0;

    private Integer peAtual = 0;
    private Integer peMaximo = 0;
    private Integer peTemporario = 0;

    private Integer integridadeAlmaAtual = 100;
    private Integer integridadeAlmaMaxima = 100;

    @Enumerated(EnumType.STRING)
    private EstadoAlma estadoAtualAlma = EstadoAlma.PURA;

    public Recursos() {
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

    public Integer getPvAtual() {
        return pvAtual;
    }

    public void setPvAtual(Integer pvAtual) {
        this.pvAtual = pvAtual;
    }

    public Integer getPvMaximo() {
        return pvMaximo;
    }

    public void setPvMaximo(Integer pvMaximo) {
        this.pvMaximo = pvMaximo;
    }

    public Integer getPvTemporario() {
        return pvTemporario;
    }

    public void setPvTemporario(Integer pvTemporario) {
        this.pvTemporario = pvTemporario;
    }

    public Integer getPeAtual() {
        return peAtual;
    }

    public void setPeAtual(Integer peAtual) {
        this.peAtual = peAtual;
    }

    public Integer getPeMaximo() {
        return peMaximo;
    }

    public void setPeMaximo(Integer peMaximo) {
        this.peMaximo = peMaximo;
    }

    public Integer getPeTemporario() {
        return peTemporario;
    }

    public void setPeTemporario(Integer peTemporario) {
        this.peTemporario = peTemporario;
    }

    public Integer getIntegridadeAlmaAtual() {
        return integridadeAlmaAtual;
    }

    public void setIntegridadeAlmaAtual(Integer integridadeAlmaAtual) {
        this.integridadeAlmaAtual = integridadeAlmaAtual;
    }

    public Integer getIntegridadeAlmaMaxima() {
        return integridadeAlmaMaxima;
    }

    public void setIntegridadeAlmaMaxima(Integer integridadeAlmaMaxima) {
        this.integridadeAlmaMaxima = integridadeAlmaMaxima;
    }

    public EstadoAlma getEstadoAtualAlma() {
        return estadoAtualAlma;
    }

    public void setEstadoAtualAlma(EstadoAlma estadoAtualAlma) {
        this.estadoAtualAlma = estadoAtualAlma;
    }
}