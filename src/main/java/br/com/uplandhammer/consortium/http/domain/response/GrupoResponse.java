package br.com.uplandhammer.consortium.http.domain.response;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Builder
public class GrupoResponse {

    private Long id;
    private Long usuarioId;
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private boolean ativo;
    private Integer diaPagamento;
}
