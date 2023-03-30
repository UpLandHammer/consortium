package br.com.uplandhammer.consortium.usecase.usuario;

import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.gateway.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CheckExistsUsuario {

    private final UsuarioRepository usuarioRepository;

    public boolean executar(String email, String nome, String telefone) {
        List<Usuario> usuario = usuarioRepository.findByEmailOrNomeOrTelefone(email, nome, telefone).orElse(null);
        return !Objects.isNull(usuario) && !usuario.isEmpty();
    }
}
