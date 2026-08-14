package br.com.autoficha.backend.repository;

import br.com.autoficha.backend.entity.TesteResistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TesteResistenciaRepository
        extends JpaRepository<TesteResistencia, Long> {

    List<TesteResistencia> findByPersonagemId(Long personagemId);

}