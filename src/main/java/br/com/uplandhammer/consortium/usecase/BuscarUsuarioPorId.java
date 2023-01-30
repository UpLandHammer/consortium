package br.com.uplandhammer.consortium.usecase;

import br.com.uplandhammer.consortium.exception.UsuarioException;
import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.gateway.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarUsuarioPorId {

    private final UsuarioRepository usuarioRepository;

    public Usuario executar(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioException(String.format("user id %s not found", id)));
    }
}
