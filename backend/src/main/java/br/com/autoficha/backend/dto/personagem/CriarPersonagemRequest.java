package br.com.autoficha.backend.dto.personagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CriarPersonagemRequest {

    @NotBlank(message = "O nome do personagem é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @Size(max = 100)
    private String jogador;

    @Size(max = 100)
    private String antecedente;

    @Size(max = 100)
    private String campanha;

    @Size(max = 100)
    private String manualDeLuta;

    @Size(max = 100)
    private String defeito;

    @Size(max = 100)
    private String profissao;

    public CriarPersonagemRequest() {
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

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
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

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}