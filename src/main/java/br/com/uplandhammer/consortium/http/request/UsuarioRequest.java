package br.com.uplandhammer.consortium.http.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String email;
    @NotEmpty
    private String telefone;
}
