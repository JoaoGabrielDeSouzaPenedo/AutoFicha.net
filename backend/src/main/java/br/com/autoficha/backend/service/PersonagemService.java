package br.com.autoficha.backend.service;

import br.com.autoficha.backend.dto.personagem.PersonagemResponse;
import br.com.autoficha.backend.dto.personagem.AtualizarPersonagemRequest;
import br.com.autoficha.backend.dto.personagem.CriarPersonagemRequest;
import br.com.autoficha.backend.dto.personagem.PersonagemResumoResponse;
import br.com.autoficha.backend.entity.*;
import br.com.autoficha.backend.exception.PersonagemNaoEncontradoException;
import br.com.autoficha.backend.repository.PersonagemRepository;
import br.com.autoficha.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;
    private final UsuarioRepository usuarioRepository;

    public PersonagemService(
            PersonagemRepository personagemRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.personagemRepository = personagemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public PersonagemResumoResponse criar(
            CriarPersonagemRequest request,
            String username
    ) {

        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow();

        Personagem personagem = new Personagem();

        personagem.setUsuario(usuario);
        personagem.setNome(request.getNome().trim());
        personagem.setJogador(request.getJogador());
        personagem.setAntecedente(request.getAntecedente());
        personagem.setCampanha(request.getCampanha());
        personagem.setManualDeLuta(request.getManualDeLuta());
        personagem.setDefeito(request.getDefeito());
        personagem.setProfissao(request.getProfissao());

        personagem.setAtributos(new Atributos());
        personagem.setRecursos(new Recursos());
        personagem.setCombate(new Combate());
        personagem.setPerfilAlma(new PerfilAlma());

        Personagem salvo =
                personagemRepository.save(personagem);

        return PersonagemResumoResponse.from(salvo);
    }

    @Transactional(readOnly = true)
    public List<PersonagemResumoResponse> listar(
            String username
    ) {

        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow();

        return personagemRepository
                .findByUsuarioIdOrderByDataAtualizacaoDesc(
                        usuario.getId()
                )
                .stream()
                .map(PersonagemResumoResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public Personagem buscarEntidade(
            Long id,
            String username
    ) {

        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow();

        return personagemRepository
                .findByIdAndUsuarioId(
                        id,
                        usuario.getId()
                )
                .orElseThrow(
                        () -> new PersonagemNaoEncontradoException(id)
                );
    }

    @Transactional
    public PersonagemResumoResponse atualizar(
            Long id,
            AtualizarPersonagemRequest request,
            String username
    ) {

        Personagem personagem =
                buscarEntidade(id, username);

        if (request.getNome() != null) {
            personagem.setNome(request.getNome());
        }

        if (request.getJogador() != null) {
            personagem.setJogador(request.getJogador());
        }

        if (request.getAntecedente() != null) {
            personagem.setAntecedente(request.getAntecedente());
        }

        if (request.getCampanha() != null) {
            personagem.setCampanha(request.getCampanha());
        }

        if (request.getManualDeLuta() != null) {
            personagem.setManualDeLuta(request.getManualDeLuta());
        }

        if (request.getDefeito() != null) {
            personagem.setDefeito(request.getDefeito());
        }

        if (request.getProfissao() != null) {
            personagem.setProfissao(request.getProfissao());
        }

        if (request.getPtGastos() != null) {
            personagem.setPtGastos(request.getPtGastos());
        }

        if (request.getRefinamento() != null) {
            personagem.setRefinamento(request.getRefinamento());
        }

        if (request.getMaestria() != null) {
            personagem.setMaestria(request.getMaestria());
        }

        if (request.getIdade() != null) {
            personagem.setIdade(request.getIdade());
        }

        if (request.getAltura() != null) {
            personagem.setAltura(request.getAltura());
        }

        if (request.getPeso() != null) {
            personagem.setPeso(request.getPeso());
        }

        if (request.getGenero() != null) {
            personagem.setGenero(request.getGenero());
        }

        if (request.getCabelos() != null) {
            personagem.setCabelos(request.getCabelos());
        }

        if (request.getOlhos() != null) {
            personagem.setOlhos(request.getOlhos());
        }

        if (request.getPele() != null) {
            personagem.setPele(request.getPele());
        }

        if (request.getRoupas() != null) {
            personagem.setRoupas(request.getRoupas());
        }

        if (request.getMarca() != null) {
            personagem.setMarca(request.getMarca());
        }

        if (request.getImagemUrl() != null) {
            personagem.setImagemUrl(request.getImagemUrl());
        }

        if (request.getIdeias() != null) {
            personagem.setIdeias(request.getIdeias());
        }

        if (request.getLigacoes() != null) {
            personagem.setLigacoes(request.getLigacoes());
        }

        if (request.getComplicacoes() != null) {
            personagem.setComplicacoes(request.getComplicacoes());
        }

        if (request.getRdResistencias() != null) {
            personagem.setRdResistencias(request.getRdResistencias());
        }

        if (request.getCaracteristicasAntecedente() != null) {
            personagem.setCaracteristicasAntecedente(
                    request.getCaracteristicasAntecedente()
            );
        }

        if (request.getPassivas() != null) {
            personagem.setPassivas(request.getPassivas());
        }

        if (request.getAnotacoes() != null) {
            personagem.setAnotacoes(request.getAnotacoes());
        }

        if (request.getDinheiro() != null) {
            personagem.setDinheiro(request.getDinheiro());
        }

        if (request.getLimiteEspaco() != null) {
            personagem.setLimiteEspaco(request.getLimiteEspaco());
        }

        return PersonagemResumoResponse.from(personagem);
    }

    @Transactional
    public void excluir(
            Long id,
            String username
    ) {

        Personagem personagem =
                buscarEntidade(id, username);

        personagemRepository.delete(personagem);
    }
    @Transactional(readOnly = true)
    public PersonagemResponse buscar(
            Long id,
            String username
    ) {

        Personagem personagem =
                buscarEntidade(id, username);

        return PersonagemResponse.from(personagem);
    }
}