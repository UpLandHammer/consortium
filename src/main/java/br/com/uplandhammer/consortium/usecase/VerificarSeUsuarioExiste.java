package br.com.uplandhammer.consortium.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerificarSeUsuarioExiste {

    private final CheckExistsUsuarioPorEmail checkExistsUsuarioPorEmail;

    private final CheckExistsUsuarioPorNome checkExistsUsuarioPorNome;

    public boolean executar(String nome, String email) {
        return checkExistsUsuarioPorNome.executar(nome) || checkExistsUsuarioPorEmail.executar(email);
    }
}
