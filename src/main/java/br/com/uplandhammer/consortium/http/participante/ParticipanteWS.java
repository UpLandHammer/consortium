package br.com.uplandhammer.consortium.http.participante;

import br.com.uplandhammer.consortium.gateway.entity.Participante;
import br.com.uplandhammer.consortium.http.domain.mapper.ParticipanteMapper;
import br.com.uplandhammer.consortium.http.domain.request.ParticipanteRequest;
import br.com.uplandhammer.consortium.http.domain.response.ParticipanteResponse;
import br.com.uplandhammer.consortium.usecase.participante.BuscarParticipantesPorGrupo;
import br.com.uplandhammer.consortium.usecase.participante.GravarParticipante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ParticipanteWS {

    private final GravarParticipante gravarParticipante;
    private final BuscarParticipantesPorGrupo buscarParticipantesPorGrupo;

    @PostMapping("/participante")
    public ResponseEntity<ParticipanteResponse> save(@RequestBody ParticipanteRequest participanteRequest) {
        Participante paciente = ParticipanteMapper.toModelFrom(participanteRequest);
        return ResponseEntity.ok().body(ParticipanteMapper.toResponseFrom(gravarParticipante.executar(paciente)));
    }

    @GetMapping("participantes/grupo/{grupoId}")
    public ResponseEntity<List<ParticipanteResponse>> findParticipantesByGrupo(@PathVariable("grupoId") Long id) {
        List<Participante> participantes = buscarParticipantesPorGrupo.executar(id);
        return ResponseEntity.ok().body(ParticipanteMapper.toResponseFrom(participantes));
    }
}
