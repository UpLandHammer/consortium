package br.com.uplandhammer.consortium.http.domain.mapper;

import br.com.uplandhammer.consortium.gateway.entity.Grupo;
import br.com.uplandhammer.consortium.gateway.entity.Participante;
import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.http.domain.request.ParticipanteRequest;
import br.com.uplandhammer.consortium.http.domain.response.ParticipanteResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ParticipanteMapper {
    public static Participante toModelFrom(ParticipanteRequest participanteRequest) {

        return Participante.builder()
                .usuario(Usuario.builder().id(participanteRequest.getIdUsuario()).build())
                .grupo(Grupo.builder().id(participanteRequest.getIdGrupo()).build())
                .ativo(true)
                .contemplado(false)
                .tipoComunicacao(participanteRequest.getTipoComunicacao())
                .build();
    }

    public static ParticipanteResponse toResponseFrom(Participante participante) {
        return ParticipanteResponse.builder()
                .id(participante.getId())
                .idGrupo(participante.getGrupo().getId())
                .idUsuario(participante.getUsuario().getId())
                .tipoComunicacao(participante.getTipoComunicacao())
                .build();
    }

    public static List<ParticipanteResponse> toResponseFrom(List<Participante> participantes) {
        return participantes != null ? participantes.stream().map(ParticipanteMapper::toResponseFrom).collect(Collectors.toList()) : null ;
    }
}
