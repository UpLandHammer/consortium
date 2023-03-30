package br.com.uplandhammer.consortium.http.domain.mapper;

import br.com.uplandhammer.consortium.gateway.entity.Grupo;
import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.http.domain.request.GrupoRequest;
import br.com.uplandhammer.consortium.http.domain.response.GrupoResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class GrupoMapper {
    public static Grupo from(GrupoRequest grupoRequest) {
        
        return Grupo.builder()
                .usuario(Usuario.builder().id(grupoRequest.getIdUsuario()).build())
                .ativo(true)
                .valor(grupoRequest.getValor())
                .dataVigenciaInicial(LocalDate.now())
                .dataVigenciaFinal(LocalDate.now().plusMonths(12))
                .diaPagamento(grupoRequest.getDiaPagamento())
                .descricao(grupoRequest.getDescricao())
                .build();
        
    }

    public static GrupoResponse toResponsefrom(Grupo grupo) {
        return GrupoResponse.builder()
                .id(grupo.getId())
                .usuarioId(grupo.getUsuario().getId())
                .valor(grupo.getValor())
                .diaPagamento(grupo.getDiaPagamento())
                .descricao(grupo.getDescricao())
                .build();

    }
}
