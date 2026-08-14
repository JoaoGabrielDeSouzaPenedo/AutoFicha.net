package br.com.autoficha.backend.entity;

import br.com.autoficha.backend.enums.AtributoBase;
import br.com.autoficha.backend.enums.TipoAlma;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "perfil_alma")
public class PerfilAlma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id", nullable = false, unique = true)
    private Personagem personagem;

    @Enumerated(EnumType.STRING)
    private TipoAlma tipoAlma;

    @Column(columnDefinition = "TEXT")
    private String beneficios;

    @Enumerated(EnumType.STRING)
    private AtributoBase atributoPrincipal;

    private Integer cdEspiritualTotal = 10;
    private Integer cdEspiritualBase = 10;
    private Integer cdEspiritualAtributo = 0;
    private Integer cdEspiritualTreino = 0;
    private Integer cdEspiritualNivel = 0;
    private Integer cdEspiritualOutros = 0;

    private Integer controleElemental = 0;
    private Integer fortificador = 0;
    private Integer amplificadorEspiritual = 0;
    private Integer desenvolvimentoEssencia = 0;
    private Integer inteligenciaAdaptada = 0;

    public PerfilAlma() {
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

    public TipoAlma getTipoAlma() {
        return tipoAlma;
    }

    public void setTipoAlma(TipoAlma tipoAlma) {
        this.tipoAlma = tipoAlma;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public AtributoBase getAtributoPrincipal() {
        return atributoPrincipal;
    }

    public void setAtributoPrincipal(AtributoBase atributoPrincipal) {
        this.atributoPrincipal = atributoPrincipal;
    }

    public Integer getCdEspiritualTotal() {
        return cdEspiritualTotal;
    }

    public void setCdEspiritualTotal(Integer cdEspiritualTotal) {
        this.cdEspiritualTotal = cdEspiritualTotal;
    }

    public Integer getCdEspiritualBase() {
        return cdEspiritualBase;
    }

    public void setCdEspiritualBase(Integer cdEspiritualBase) {
        this.cdEspiritualBase = cdEspiritualBase;
    }

    public Integer getCdEspiritualAtributo() {
        return cdEspiritualAtributo;
    }

    public void setCdEspiritualAtributo(Integer cdEspiritualAtributo) {
        this.cdEspiritualAtributo = cdEspiritualAtributo;
    }

    public Integer getCdEspiritualTreino() {
        return cdEspiritualTreino;
    }

    public void setCdEspiritualTreino(Integer cdEspiritualTreino) {
        this.cdEspiritualTreino = cdEspiritualTreino;
    }

    public Integer getCdEspiritualNivel() {
        return cdEspiritualNivel;
    }

    public void setCdEspiritualNivel(Integer cdEspiritualNivel) {
        this.cdEspiritualNivel = cdEspiritualNivel;
    }

    public Integer getCdEspiritualOutros() {
        return cdEspiritualOutros;
    }

    public void setCdEspiritualOutros(Integer cdEspiritualOutros) {
        this.cdEspiritualOutros = cdEspiritualOutros;
    }

    public Integer getControleElemental() {
        return controleElemental;
    }

    public void setControleElemental(Integer controleElemental) {
        this.controleElemental = controleElemental;
    }

    public Integer getFortificador() {
        return fortificador;
    }

    public void setFortificador(Integer fortificador) {
        this.fortificador = fortificador;
    }

    public Integer getAmplificadorEspiritual() {
        return amplificadorEspiritual;
    }

    public void setAmplificadorEspiritual(Integer amplificadorEspiritual) {
        this.amplificadorEspiritual = amplificadorEspiritual;
    }

    public Integer getDesenvolvimentoEssencia() {
        return desenvolvimentoEssencia;
    }

    public void setDesenvolvimentoEssencia(Integer desenvolvimentoEssencia) {
        this.desenvolvimentoEssencia = desenvolvimentoEssencia;
    }

    public Integer getInteligenciaAdaptada() {
        return inteligenciaAdaptada;
    }

    public void setInteligenciaAdaptada(Integer inteligenciaAdaptada) {
        this.inteligenciaAdaptada = inteligenciaAdaptada;
    }
}