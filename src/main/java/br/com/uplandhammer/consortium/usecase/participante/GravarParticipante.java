package br.com.uplandhammer.consortium.usecase.participante;

import br.com.uplandhammer.consortium.exception.ParticipanteException;
import br.com.uplandhammer.consortium.gateway.entity.Participante;
import br.com.uplandhammer.consortium.gateway.repositories.ParticipanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GravarParticipante {
    private final ParticipanteRepository participanteRepository;
    public Participante executar(Participante participante) {
        try {
            return participanteRepository.save(participante);
        } catch (Exception exception) {
            throw new ParticipanteException("Erro ao gravar participante", exception);
        }

    }
}
