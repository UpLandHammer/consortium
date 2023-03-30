package br.com.uplandhammer.consortium.usecase.parcelas;

import br.com.uplandhammer.consortium.exception.GrupoException;
import br.com.uplandhammer.consortium.gateway.entity.Grupo;
import br.com.uplandhammer.consortium.gateway.entity.Participante;
import br.com.uplandhammer.consortium.gateway.entity.Prestacao;
import br.com.uplandhammer.consortium.gateway.repositories.ParticipanteRepository;
import br.com.uplandhammer.consortium.gateway.repositories.PrestacaoRepository;
import br.com.uplandhammer.consortium.usecase.grupo.BuscarGrupoPorId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class GerarParcelasPorGrupo {

    private final ParticipanteRepository participanteRepository;
    private final BuscarGrupoPorId buscarGrupoPorId;

    private final PrestacaoRepository prestacaoRepository;

    public void executar(Long id) {
        Grupo grupo = buscarGrupoPorId.executar(id);

        BigDecimal valor = grupo.getValor();

        List<Participante> participantes = participanteRepository.findByGrupoId(id);

        if (participantes.isEmpty())
            throw new GrupoException("Grupo sem participantes");

        int numeroParticipantesQuantidadeParcelas = participantes.size();

        BigDecimal valorPrestacao = valor.divide(BigDecimal.valueOf(numeroParticipantesQuantidadeParcelas));

        participantes.forEach(p -> {
            IntStream.rangeClosed(1, numeroParticipantesQuantidadeParcelas)
                    .forEach(numeroPrestacao -> {
                        Prestacao prestacao = Prestacao.builder()
                                .usuario(p.getUsuario())
                                .valor(valorPrestacao)
                                .numeroPrestacao(numeroPrestacao)
                                .dataVencimento(LocalDate.now().plusMonths(numeroPrestacao))
                                .status(false)
                                .build();
                        prestacaoRepository.save(prestacao);
                    });
        });

    }
}
