package br.com.autoficha.backend.dto.personagem;

import br.com.autoficha.backend.entity.Personagem;

import java.time.LocalDateTime;

public class PersonagemResumoResponse {

    private Long id;
    private String nome;
    private String jogador;
    private String antecedente;
    private String campanha;
    private String imagemUrl;
    private Integer refinamento;
    private LocalDateTime dataAtualizacao;

    public PersonagemResumoResponse() {
    }

    public static PersonagemResumoResponse from(Personagem personagem) {

        PersonagemResumoResponse response =
                new PersonagemResumoResponse();

        response.id = personagem.getId();
        response.nome = personagem.getNome();
        response.jogador = personagem.getJogador();
        response.antecedente = personagem.getAntecedente();
        response.campanha = personagem.getCampanha();
        response.imagemUrl = personagem.getImagemUrl();
        response.refinamento = personagem.getRefinamento();
        response.dataAtualizacao = personagem.getDataAtualizacao();

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

    public String getAntecedente() {
        return antecedente;
    }

    public String getCampanha() {
        return campanha;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public Integer getRefinamento() {
        return refinamento;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}