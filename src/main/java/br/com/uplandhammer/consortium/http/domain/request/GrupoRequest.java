package br.com.uplandhammer.consortium.http.domain.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrupoRequest {

    @NotNull
    private Long idUsuario;
    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;
    @NotNull
    @Min(value = 1)
    @Max(value = 31)
    private Integer diaPagamento;
}
