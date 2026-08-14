package br.com.autoficha.backend.dto.personagem;

import br.com.autoficha.backend.entity.Personagem;
import br.com.autoficha.backend.enums.FamiliaNobre;
import br.com.autoficha.backend.enums.TipoAntecedente;
import br.com.autoficha.backend.enums.TipoDefeito;

public class PersonagemResumoResponse {

    private Long id;

    private String nome;
    private String jogador;

    private TipoAntecedente antecedente;
    private FamiliaNobre familiaNobre;
    private TipoDefeito defeito;

    private String campanha;
    private String profissao;

    private Integer refinamento;
    private Integer maestria;

    public PersonagemResumoResponse() {
    }

    public static PersonagemResumoResponse from(Personagem personagem) {

        PersonagemResumoResponse response =
                new PersonagemResumoResponse();

        response.id = personagem.getId();

        response.nome = personagem.getNome();
        response.jogador = personagem.getJogador();

        response.antecedente = personagem.getAntecedente();
        response.familiaNobre = personagem.getFamiliaNobre();
        response.defeito = personagem.getDefeito();

        response.campanha = personagem.getCampanha();
        response.profissao = personagem.getProfissao();

        response.refinamento = personagem.getRefinamento();
        response.maestria = personagem.getMaestria();

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

    public TipoDefeito getDefeito() {
        return defeito;
    }

    public String getCampanha() {
        return campanha;
    }

    public String getProfissao() {
        return profissao;
    }

    public Integer getRefinamento() {
        return refinamento;
    }

    public Integer getMaestria() {
        return maestria;
    }
}