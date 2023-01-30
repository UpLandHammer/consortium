package br.com.uplandhammer.consortium.http.mapper;

import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.http.request.UsuarioRequest;
import br.com.uplandhammer.consortium.http.response.UsuarioResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public static UsuarioResponse from(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .telefone(usuario.getTelefone())
                .build();
    }

    public static Usuario from(UsuarioRequest usuarioRequest) {
        return Usuario.builder()
                .nome(usuarioRequest.getNome())
                .email(usuarioRequest.getEmail())
                .telefone(usuarioRequest.getTelefone())
                .build();
    }
}
