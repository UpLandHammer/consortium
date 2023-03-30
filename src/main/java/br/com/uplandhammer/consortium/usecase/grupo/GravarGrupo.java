package br.com.uplandhammer.consortium.usecase.grupo;

import br.com.uplandhammer.consortium.gateway.entity.Grupo;
import br.com.uplandhammer.consortium.gateway.repositories.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GravarGrupo {

    private final GrupoRepository grupoRepository;

    public Grupo executar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }


}
