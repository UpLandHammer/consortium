package br.com.uplandhammer.consortium.http.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Builder
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotBlank(message = "Atributo nome não pode estar vazio.")
    private String nome;
    @NotBlank(message = "Atributo email não pode estar vazio.")
    private String email;
    @NotBlank(message = "Atributo telefone não pode estar vazio.")
    private String telefone;
}
