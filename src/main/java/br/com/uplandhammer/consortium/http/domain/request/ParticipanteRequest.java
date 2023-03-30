package br.com.uplandhammer.consortium.http.domain.request;

import br.com.uplandhammer.consortium.gateway.entity.enums.TipoComunicacao;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipanteRequest {

    @NotNull
    private Long idUsuario;
    @NotNull
    private Long idGrupo;
    @NotNull
    private TipoComunicacao tipoComunicacao;
}
