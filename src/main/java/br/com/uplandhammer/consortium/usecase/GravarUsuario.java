package br.com.uplandhammer.consortium.usecase;

import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.gateway.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GravarUsuario {

    private final UsuarioRepository usuarioRepository;

    public Usuario executar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
