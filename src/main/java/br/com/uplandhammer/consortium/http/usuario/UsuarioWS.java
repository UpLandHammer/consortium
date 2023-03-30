package br.com.uplandhammer.consortium.http.usuario;

import br.com.uplandhammer.consortium.exception.BindingValidationException;
import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import br.com.uplandhammer.consortium.http.domain.mapper.UsuarioMapper;
import br.com.uplandhammer.consortium.http.domain.request.UsuarioRequest;
import br.com.uplandhammer.consortium.http.domain.response.UsuarioResponse;
import br.com.uplandhammer.consortium.http.utils.UriUtils;
import br.com.uplandhammer.consortium.usecase.usuario.BuscarUsuarioPorId;
import br.com.uplandhammer.consortium.usecase.usuario.GravarUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuario")
public class UsuarioWS {

    private final GravarUsuario gravarUsuario;
    private final BuscarUsuarioPorId buscarUsuarioPorId;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(UsuarioMapper.from(buscarUsuarioPorId.executar(id)));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest usuarioRequest, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        throwBeanValidationErrors(bindingResult);
        Usuario usuario = UsuarioMapper.from(usuarioRequest);
        UsuarioResponse usuarioCreated = UsuarioMapper.from(gravarUsuario.executar(usuario));
        return ResponseEntity.created(UriUtils.generateResourceUriLocation(uriComponentsBuilder, "/api/usuario/{id}", usuarioCreated.getId())).body(usuarioCreated);
    }

    private static void throwBeanValidationErrors(BindingResult bindingResult) {
        List<String> messages = bindingResult
                .getAllErrors()
                .stream()
                .map(m -> m.getCode() + " " +  m.getDefaultMessage() + "\n")
                .toList();
        if(bindingResult.hasErrors())
            throw new BindingValidationException(messages);
    }
}
