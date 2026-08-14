package br.com.autoficha.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "atributos")
public class Atributos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id", nullable = false, unique = true)
    private Personagem personagem;

    // =========================
    // FORÇA
    // =========================

    private Integer forcaValor = 10;
    private Integer forcaMod = 0;

    // =========================
    // DESTREZA
    // =========================

    private Integer destrezaValor = 10;
    private Integer destrezaMod = 0;

    // =========================
    // CONSTITUIÇÃO
    // =========================

    private Integer constituicaoValor = 10;
    private Integer constituicaoMod = 0;

    // =========================
    // INTELIGÊNCIA
    // =========================

    private Integer inteligenciaValor = 10;
    private Integer inteligenciaMod = 0;

    // =========================
    // SABEDORIA
    // =========================

    private Integer sabedoriaValor = 10;
    private Integer sabedoriaMod = 0;

    // =========================
    // PRESENÇA
    // =========================

    private Integer presencaValor = 10;
    private Integer presencaMod = 0;

    public Atributos() {
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

    public Integer getForcaValor() {
        return forcaValor;
    }

    public void setForcaValor(Integer forcaValor) {
        this.forcaValor = forcaValor;
    }

    public Integer getForcaMod() {
        return forcaMod;
    }

    public void setForcaMod(Integer forcaMod) {
        this.forcaMod = forcaMod;
    }

    public Integer getDestrezaValor() {
        return destrezaValor;
    }

    public void setDestrezaValor(Integer destrezaValor) {
        this.destrezaValor = destrezaValor;
    }

    public Integer getDestrezaMod() {
        return destrezaMod;
    }

    public void setDestrezaMod(Integer destrezaMod) {
        this.destrezaMod = destrezaMod;
    }

    public Integer getConstituicaoValor() {
        return constituicaoValor;
    }

    public void setConstituicaoValor(Integer constituicaoValor) {
        this.constituicaoValor = constituicaoValor;
    }

    public Integer getConstituicaoMod() {
        return constituicaoMod;
    }

    public void setConstituicaoMod(Integer constituicaoMod) {
        this.constituicaoMod = constituicaoMod;
    }

    public Integer getInteligenciaValor() {
        return inteligenciaValor;
    }

    public void setInteligenciaValor(Integer inteligenciaValor) {
        this.inteligenciaValor = inteligenciaValor;
    }

    public Integer getInteligenciaMod() {
        return inteligenciaMod;
    }

    public void setInteligenciaMod(Integer inteligenciaMod) {
        this.inteligenciaMod = inteligenciaMod;
    }

    public Integer getSabedoriaValor() {
        return sabedoriaValor;
    }

    public void setSabedoriaValor(Integer sabedoriaValor) {
        this.sabedoriaValor = sabedoriaValor;
    }

    public Integer getSabedoriaMod() {
        return sabedoriaMod;
    }

    public void setSabedoriaMod(Integer sabedoriaMod) {
        this.sabedoriaMod = sabedoriaMod;
    }

    public Integer getPresencaValor() {
        return presencaValor;
    }

    public void setPresencaValor(Integer presencaValor) {
        this.presencaValor = presencaValor;
    }

    public Integer getPresencaMod() {
        return presencaMod;
    }

    public void setPresencaMod(Integer presencaMod) {
        this.presencaMod = presencaMod;
    }
}