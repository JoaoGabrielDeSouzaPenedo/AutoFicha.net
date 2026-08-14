package br.com.autoficha.backend.dto.personagem;

import br.com.autoficha.backend.enums.FamiliaNobre;
import br.com.autoficha.backend.enums.Genero;
import br.com.autoficha.backend.enums.TipoAntecedente;
import br.com.autoficha.backend.enums.TipoDefeito;

import java.math.BigDecimal;

public class AtualizarPersonagemRequest {

    private String nome;
    private String jogador;

    private TipoAntecedente antecedente;
    private FamiliaNobre familiaNobre;

    private String campanha;
    private String manualDeLuta;

    private TipoDefeito defeito;

    private Integer ptGastos;
    private Integer refinamento;
    private Integer maestria;

    private String profissao;

    private Integer idade;

    private BigDecimal altura;
    private BigDecimal peso;

    private Genero genero;

    private String cabelos;
    private String olhos;
    private String pele;
    private String roupas;
    private String marca;
    private String imagemUrl;

    private String ideias;
    private String ligacoes;
    private String complicacoes;

    private String rdResistencias;
    private String caracteristicasAntecedente;
    private String passivas;
    private String anotacoes;

    private BigDecimal dinheiro;
    private BigDecimal limiteEspaco;

    public AtualizarPersonagemRequest() {
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

    public TipoAntecedente getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(TipoAntecedente antecedente) {
        this.antecedente = antecedente;
    }

    public FamiliaNobre getFamiliaNobre() {
        return familiaNobre;
    }

    public void setFamiliaNobre(FamiliaNobre familiaNobre) {
        this.familiaNobre = familiaNobre;
    }

    public String getCampanha() {
        return campanha;
    }

    public void setCampanha(String campanha) {
        this.campanha = campanha;
    }

    public String getManualDeLuta() {
        return manualDeLuta;
    }

    public void setManualDeLuta(String manualDeLuta) {
        this.manualDeLuta = manualDeLuta;
    }

    public TipoDefeito getDefeito() {
        return defeito;
    }

    public void setDefeito(TipoDefeito defeito) {
        this.defeito = defeito;
    }

    public Integer getPtGastos() {
        return ptGastos;
    }

    public void setPtGastos(Integer ptGastos) {
        this.ptGastos = ptGastos;
    }

    public Integer getRefinamento() {
        return refinamento;
    }

    public void setRefinamento(Integer refinamento) {
        this.refinamento = refinamento;
    }

    public Integer getMaestria() {
        return maestria;
    }

    public void setMaestria(Integer maestria) {
        this.maestria = maestria;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getCabelos() {
        return cabelos;
    }

    public void setCabelos(String cabelos) {
        this.cabelos = cabelos;
    }

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public String getRoupas() {
        return roupas;
    }

    public void setRoupas(String roupas) {
        this.roupas = roupas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getIdeias() {
        return ideias;
    }

    public void setIdeias(String ideias) {
        this.ideias = ideias;
    }

    public String getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(String ligacoes) {
        this.ligacoes = ligacoes;
    }

    public String getComplicacoes() {
        return complicacoes;
    }

    public void setComplicacoes(String complicacoes) {
        this.complicacoes = complicacoes;
    }

    public String getRdResistencias() {
        return rdResistencias;
    }

    public void setRdResistencias(String rdResistencias) {
        this.rdResistencias = rdResistencias;
    }

    public String getCaracteristicasAntecedente() {
        return caracteristicasAntecedente;
    }

    public void setCaracteristicasAntecedente(String caracteristicasAntecedente) {
        this.caracteristicasAntecedente = caracteristicasAntecedente;
    }

    public String getPassivas() {
        return passivas;
    }

    public void setPassivas(String passivas) {
        this.passivas = passivas;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public BigDecimal getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(BigDecimal dinheiro) {
        this.dinheiro = dinheiro;
    }

    public BigDecimal getLimiteEspaco() {
        return limiteEspaco;
    }

    public void setLimiteEspaco(BigDecimal limiteEspaco) {
        this.limiteEspaco = limiteEspaco;
    }
}