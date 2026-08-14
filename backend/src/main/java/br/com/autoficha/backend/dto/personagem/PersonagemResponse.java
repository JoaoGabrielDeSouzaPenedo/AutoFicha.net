package br.com.autoficha.backend.dto.personagem;

import br.com.autoficha.backend.entity.Personagem;
import br.com.autoficha.backend.enums.FamiliaNobre;
import br.com.autoficha.backend.enums.Genero;
import br.com.autoficha.backend.enums.TipoAntecedente;
import br.com.autoficha.backend.enums.TipoDefeito;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PersonagemResponse {

    private Long id;

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

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public PersonagemResponse() {
    }

    public static PersonagemResponse from(Personagem personagem) {

        PersonagemResponse response =
                new PersonagemResponse();

        response.id = personagem.getId();

        response.nome = personagem.getNome();
        response.jogador = personagem.getJogador();

        response.antecedente =
                personagem.getAntecedente();

        response.familiaNobre =
                personagem.getFamiliaNobre();

        response.campanha =
                personagem.getCampanha();

        response.manualDeLuta =
                personagem.getManualDeLuta();

        response.defeito =
                personagem.getDefeito();

        response.ptGastos =
                personagem.getPtGastos();

        response.refinamento =
                personagem.getRefinamento();

        response.maestria =
                personagem.getMaestria();

        response.profissao =
                personagem.getProfissao();

        response.idade =
                personagem.getIdade();

        response.altura =
                personagem.getAltura();

        response.peso =
                personagem.getPeso();

        response.genero =
                personagem.getGenero();

        response.cabelos =
                personagem.getCabelos();

        response.olhos =
                personagem.getOlhos();

        response.pele =
                personagem.getPele();

        response.roupas =
                personagem.getRoupas();

        response.marca =
                personagem.getMarca();

        response.imagemUrl =
                personagem.getImagemUrl();

        response.ideias =
                personagem.getIdeias();

        response.ligacoes =
                personagem.getLigacoes();

        response.complicacoes =
                personagem.getComplicacoes();

        response.rdResistencias =
                personagem.getRdResistencias();

        response.caracteristicasAntecedente =
                personagem.getCaracteristicasAntecedente();

        response.passivas =
                personagem.getPassivas();

        response.anotacoes =
                personagem.getAnotacoes();

        response.dinheiro =
                personagem.getDinheiro();

        response.limiteEspaco =
                personagem.getLimiteEspaco();

        response.dataCriacao =
                personagem.getDataCriacao();

        response.dataAtualizacao =
                personagem.getDataAtualizacao();

        return response;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getJogador() {
        return jogador;
    }

    public TipoAntecedente getAntecedente() {
        return antecedente;
    }

    public FamiliaNobre getFamiliaNobre() {
        return familiaNobre;
    }

    public String getCampanha() {
        return campanha;
    }

    public String getManualDeLuta() {
        return manualDeLuta;
    }

    public TipoDefeito getDefeito() {
        return defeito;
    }

    public Integer getPtGastos() {
        return ptGastos;
    }

    public Integer getRefinamento() {
        return refinamento;
    }

    public Integer getMaestria() {
        return maestria;
    }

    public String getProfissao() {
        return profissao;
    }

    public Integer getIdade() {
        return idade;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getCabelos() {
        return cabelos;
    }

    public String getOlhos() {
        return olhos;
    }

    public String getPele() {
        return pele;
    }

    public String getRoupas() {
        return roupas;
    }

    public String getMarca() {
        return marca;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public String getIdeias() {
        return ideias;
    }

    public String getLigacoes() {
        return ligacoes;
    }

    public String getComplicacoes() {
        return complicacoes;
    }

    public String getRdResistencias() {
        return rdResistencias;
    }

    public String getCaracteristicasAntecedente() {
        return caracteristicasAntecedente;
    }

    public String getPassivas() {
        return passivas;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public BigDecimal getDinheiro() {
        return dinheiro;
    }

    public BigDecimal getLimiteEspaco() {
        return limiteEspaco;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}