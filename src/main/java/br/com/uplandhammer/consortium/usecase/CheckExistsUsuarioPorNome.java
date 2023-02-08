package br.com.uplandhammer.consortium.usecase;

import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.gateway.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CheckExistsUsuarioPorNome {

    private final UsuarioRepository usuarioRepository;

    public boolean executar(String nome) {
        Usuario usuario = usuarioRepository.findByNome(nome).orElse(null);
        return !Objects.isNull(usuario);
    }
}
