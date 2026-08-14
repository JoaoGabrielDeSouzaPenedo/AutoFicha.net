package br.com.autoficha.backend.repository;

import br.com.autoficha.backend.entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    List<Personagem> findByUsuarioIdOrderByDataAtualizacaoDesc(Long usuarioId);

    Optional<Personagem> findByIdAndUsuarioId(Long id, Long usuarioId);

    boolean existsByIdAndUsuarioId(Long id, Long usuarioId);
}