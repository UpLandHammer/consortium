package br.com.uplandhammer.consortium.usecase.participante;

import br.com.uplandhammer.consortium.gateway.entity.Participante;
import br.com.uplandhammer.consortium.gateway.repositories.ParticipanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarParticipantesPorGrupo {

    private final ParticipanteRepository participanteRepository;

    public List<Participante> executar(Long id) {
        return participanteRepository.findByGrupoId(id);
    }
}
