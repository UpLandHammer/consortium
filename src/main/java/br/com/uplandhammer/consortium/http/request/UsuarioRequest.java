package br.com.uplandhammer.consortium.http.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Builder
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotEmpty(message = "Atributo nome não pode estar vazio.")
    @NotNull(message = "Campo nome obrigatório.")
    private String nome;
    @NotEmpty(message = "Atributo email não pode estar vazio.")
    @NotNull(message = "Campo e-mail obrigatório.")
    private String email;
    @NotEmpty(message = "Atributo telefone não pode estar vazio.")
    @NotNull(message = "Campo telefone obrigatório.")
    private String telefone;
}
