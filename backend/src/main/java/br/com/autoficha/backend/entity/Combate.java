package br.com.autoficha.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "combate")
public class Combate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id", nullable = false, unique = true)
    private Personagem personagem;

    // =========================
    // DEFESA
    // =========================

    private Integer defesaTotal = 10;
    private Integer defesaBase = 10;
    private Integer defesaEquipamento = 0;
    private Integer defesaDestreza = 0;
    private Integer defesaRefinamento = 0;
    private Integer defesaOutros = 0;

    // =========================
    // CD
    // =========================

    private Integer cdTotal = 10;
    private Integer cdBase = 10;
    private Integer cdAtributo = 0;
    private Integer cdMaestria = 0;
    private Integer cdRefinamento = 0;
    private Integer cdOutros = 0;

    // =========================
    // DESLOCAMENTO
    // =========================

    private Integer deslocamento = 9;

    // =========================
    // ATENÇÃO
    // =========================

    private Integer atencaoTotal = 10;
    private Integer atencaoBase = 10;
    private Integer atencaoPercepcao = 0;
    private Integer atencaoOutros = 0;

    // =========================
    // INICIATIVA
    // =========================

    private Integer iniciativaTotal = 0;
    private Integer iniciativaDestreza = 0;
    private Integer iniciativaOutros = 0;

    // =========================
    // JOGADAS DE ATAQUE
    // =========================

    private Integer ataqueCorpoACorpo = 0;
    private Integer ataqueDistancia = 0;
    private Integer ataqueEnergia = 0;

    // =========================
    // TESTES DE RESISTÊNCIA
    // =========================

    private Integer astucia = 0;
    private Integer fortitude = 0;
    private Integer integridade = 0;
    private Integer reflexos = 0;
    private Integer vontade = 0;

    // =========================
    // TESTES DE MORTE
    // =========================

    private Integer sucessosMorte = 0;
    private Integer falhasMorte = 0;

    // =========================
    // DADOS DE EVOLUÇÃO
    // =========================

    private Integer dadoPvD6 = 0;
    private Integer dadoPvD8 = 0;
    private Integer dadoPvD10 = 0;
    private Integer dadoPvD12 = 0;

    private Integer dadoPeD4 = 0;
    private Integer dadoPeD6 = 0;
    private Integer dadoPeD8 = 0;
    private Integer dadoPeD10 = 0;

    public Combate() {
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

    public Integer getDefesaTotal() {
        return defesaTotal;
    }

    public void setDefesaTotal(Integer defesaTotal) {
        this.defesaTotal = defesaTotal;
    }

    public Integer getDefesaBase() {
        return defesaBase;
    }

    public void setDefesaBase(Integer defesaBase) {
        this.defesaBase = defesaBase;
    }

    public Integer getDefesaEquipamento() {
        return defesaEquipamento;
    }

    public void setDefesaEquipamento(Integer defesaEquipamento) {
        this.defesaEquipamento = defesaEquipamento;
    }

    public Integer getDefesaDestreza() {
        return defesaDestreza;
    }

    public void setDefesaDestreza(Integer defesaDestreza) {
        this.defesaDestreza = defesaDestreza;
    }

    public Integer getDefesaRefinamento() {
        return defesaRefinamento;
    }

    public void setDefesaRefinamento(Integer defesaRefinamento) {
        this.defesaRefinamento = defesaRefinamento;
    }

    public Integer getDefesaOutros() {
        return defesaOutros;
    }

    public void setDefesaOutros(Integer defesaOutros) {
        this.defesaOutros = defesaOutros;
    }

    public Integer getCdTotal() {
        return cdTotal;
    }

    public void setCdTotal(Integer cdTotal) {
        this.cdTotal = cdTotal;
    }

    public Integer getCdBase() {
        return cdBase;
    }

    public void setCdBase(Integer cdBase) {
        this.cdBase = cdBase;
    }

    public Integer getCdAtributo() {
        return cdAtributo;
    }

    public void setCdAtributo(Integer cdAtributo) {
        this.cdAtributo = cdAtributo;
    }

    public Integer getCdMaestria() {
        return cdMaestria;
    }

    public void setCdMaestria(Integer cdMaestria) {
        this.cdMaestria = cdMaestria;
    }

    public Integer getCdRefinamento() {
        return cdRefinamento;
    }

    public void setCdRefinamento(Integer cdRefinamento) {
        this.cdRefinamento = cdRefinamento;
    }

    public Integer getCdOutros() {
        return cdOutros;
    }

    public void setCdOutros(Integer cdOutros) {
        this.cdOutros = cdOutros;
    }

    public Integer getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(Integer deslocamento) {
        this.deslocamento = deslocamento;
    }

    public Integer getAtencaoTotal() {
        return atencaoTotal;
    }

    public void setAtencaoTotal(Integer atencaoTotal) {
        this.atencaoTotal = atencaoTotal;
    }

    public Integer getAtencaoBase() {
        return atencaoBase;
    }

    public void setAtencaoBase(Integer atencaoBase) {
        this.atencaoBase = atencaoBase;
    }

    public Integer getAtencaoPercepcao() {
        return atencaoPercepcao;
    }

    public void setAtencaoPercepcao(Integer atencaoPercepcao) {
        this.atencaoPercepcao = atencaoPercepcao;
    }

    public Integer getAtencaoOutros() {
        return atencaoOutros;
    }

    public void setAtencaoOutros(Integer atencaoOutros) {
        this.atencaoOutros = atencaoOutros;
    }

    public Integer getIniciativaTotal() {
        return iniciativaTotal;
    }

    public void setIniciativaTotal(Integer iniciativaTotal) {
        this.iniciativaTotal = iniciativaTotal;
    }

    public Integer getIniciativaDestreza() {
        return iniciativaDestreza;
    }

    public void setIniciativaDestreza(Integer iniciativaDestreza) {
        this.iniciativaDestreza = iniciativaDestreza;
    }

    public Integer getIniciativaOutros() {
        return iniciativaOutros;
    }

    public void setIniciativaOutros(Integer iniciativaOutros) {
        this.iniciativaOutros = iniciativaOutros;
    }

    public Integer getAtaqueCorpoACorpo() {
        return ataqueCorpoACorpo;
    }

    public void setAtaqueCorpoACorpo(Integer ataqueCorpoACorpo) {
        this.ataqueCorpoACorpo = ataqueCorpoACorpo;
    }

    public Integer getAtaqueDistancia() {
        return ataqueDistancia;
    }

    public void setAtaqueDistancia(Integer ataqueDistancia) {
        this.ataqueDistancia = ataqueDistancia;
    }

    public Integer getAtaqueEnergia() {
        return ataqueEnergia;
    }

    public void setAtaqueEnergia(Integer ataqueEnergia) {
        this.ataqueEnergia = ataqueEnergia;
    }

    public Integer getAstucia() {
        return astucia;
    }

    public void setAstucia(Integer astucia) {
        this.astucia = astucia;
    }

    public Integer getFortitude() {
        return fortitude;
    }

    public void setFortitude(Integer fortitude) {
        this.fortitude = fortitude;
    }

    public Integer getIntegridade() {
        return integridade;
    }

    public void setIntegridade(Integer integridade) {
        this.integridade = integridade;
    }

    public Integer getReflexos() {
        return reflexos;
    }

    public void setReflexos(Integer reflexos) {
        this.reflexos = reflexos;
    }

    public Integer getVontade() {
        return vontade;
    }

    public void setVontade(Integer vontade) {
        this.vontade = vontade;
    }

    public Integer getSucessosMorte() {
        return sucessosMorte;
    }

    public void setSucessosMorte(Integer sucessosMorte) {
        this.sucessosMorte = sucessosMorte;
    }

    public Integer getFalhasMorte() {
        return falhasMorte;
    }

    public void setFalhasMorte(Integer falhasMorte) {
        this.falhasMorte = falhasMorte;
    }

    public Integer getDadoPvD6() {
        return dadoPvD6;
    }

    public void setDadoPvD6(Integer dadoPvD6) {
        this.dadoPvD6 = dadoPvD6;
    }

    public Integer getDadoPvD8() {
        return dadoPvD8;
    }

    public void setDadoPvD8(Integer dadoPvD8) {
        this.dadoPvD8 = dadoPvD8;
    }

    public Integer getDadoPvD10() {
        return dadoPvD10;
    }

    public void setDadoPvD10(Integer dadoPvD10) {
        this.dadoPvD10 = dadoPvD10;
    }

    public Integer getDadoPvD12() {
        return dadoPvD12;
    }

    public void setDadoPvD12(Integer dadoPvD12) {
        this.dadoPvD12 = dadoPvD12;
    }

    public Integer getDadoPeD4() {
        return dadoPeD4;
    }

    public void setDadoPeD4(Integer dadoPeD4) {
        this.dadoPeD4 = dadoPeD4;
    }

    public Integer getDadoPeD6() {
        return dadoPeD6;
    }

    public void setDadoPeD6(Integer dadoPeD6) {
        this.dadoPeD6 = dadoPeD6;
    }

    public Integer getDadoPeD8() {
        return dadoPeD8;
    }

    public void setDadoPeD8(Integer dadoPeD8) {
        this.dadoPeD8 = dadoPeD8;
    }

    public Integer getDadoPeD10() {
        return dadoPeD10;
    }

    public void setDadoPeD10(Integer dadoPeD10) {
        this.dadoPeD10 = dadoPeD10;
    }
}