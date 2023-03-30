package br.com.uplandhammer.consortium.gateway.repositories;

import br.com.uplandhammer.consortium.gateway.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    List<Participante> findByGrupoId(Long id);
}
