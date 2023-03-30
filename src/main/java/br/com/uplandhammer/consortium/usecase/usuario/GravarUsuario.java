package br.com.uplandhammer.consortium.usecase.usuario;

import br.com.uplandhammer.consortium.exception.GravarUsuarioException;
import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.gateway.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GravarUsuario {

    private final UsuarioRepository usuarioRepository;
    private final VerificarSeUsuarioExiste verificarSeUsuarioExiste;

    public Usuario executar(Usuario usuario) {

        if(verificarSeUsuarioExiste.executar(usuario.getNome(), usuario.getEmail(), usuario.getTelefone()))
            throw new GravarUsuarioException("Já existe um usuário com o mesmo nome ou email ou telefone!");

        return usuarioRepository.save(usuario);
    }
}
