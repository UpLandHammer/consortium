package br.com.uplandhammer.consortium.http.usuario;

import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.http.mapper.UsuarioMapper;
import br.com.uplandhammer.consortium.http.request.UsuarioRequest;
import br.com.uplandhammer.consortium.http.response.UsuarioResponse;
import br.com.uplandhammer.consortium.usecase.GravarUsuario;
import br.com.uplandhammer.consortium.usecase.BuscarUsuarioPorId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioWS {

    private final GravarUsuario gravarUsuario;
    private final BuscarUsuarioPorId buscarUsuarioPorId;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(UsuarioMapper.from(buscarUsuarioPorId.executar(id)));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = UsuarioMapper.from(usuarioRequest);
        return ResponseEntity.ok().body(UsuarioMapper.from(gravarUsuario.executar(usuario)));
    }
}
