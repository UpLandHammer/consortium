package br.com.uplandhammer.consortium.usecase.grupo;

import br.com.uplandhammer.consortium.exception.GrupoException;
import br.com.uplandhammer.consortium.gateway.entity.Grupo;
import br.com.uplandhammer.consortium.gateway.repositories.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarGrupoPorId {

    private final GrupoRepository grupoRepository;

    public Grupo executar(Long id) {
        return grupoRepository.findById(id).orElseThrow(() -> new GrupoException(String.format("Usuário id %s não encontrado", id)));
    }
}
