package br.com.uplandhammer.consortium.http.domain.response;

import br.com.uplandhammer.consortium.gateway.entity.enums.TipoComunicacao;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParticipanteResponse {

    private Long id;
    private Long idUsuario;
    private Long idGrupo;
    private TipoComunicacao tipoComunicacao;
}
