package br.com.uplandhammer.consortium.usecase.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerificarSeUsuarioExiste {

    private final CheckExistsUsuario checkExistsUsuario;
    public boolean executar(String nome, String email, String telefone) {
        return checkExistsUsuario.executar(email, nome, telefone);
    }
}
