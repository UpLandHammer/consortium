package br.com.uplandhammer.consortium.http.grupo;

import br.com.uplandhammer.consortium.gateway.entity.Grupo;
import br.com.uplandhammer.consortium.http.domain.mapper.GrupoMapper;
import br.com.uplandhammer.consortium.http.domain.response.GrupoResponse;
import br.com.uplandhammer.consortium.http.utils.UriUtils;
import br.com.uplandhammer.consortium.usecase.parcelas.GerarParcelasPorGrupo;
import br.com.uplandhammer.consortium.usecase.grupo.BuscarGrupoPorId;
import br.com.uplandhammer.consortium.usecase.grupo.GravarGrupo;
import br.com.uplandhammer.consortium.http.domain.request.GrupoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grupo")
public class GrupoWS {

    private final GravarGrupo gravarGrupo;
    private final BuscarGrupoPorId buscarGrupoPorId;
    private final GerarParcelasPorGrupo gerarParcelasPorGrupo;

    @PostMapping
    public ResponseEntity<GrupoResponse> save(@RequestBody GrupoRequest grupoRequest, UriComponentsBuilder uriComponentsBuilder) {
        Grupo grupo = GrupoMapper.from(grupoRequest);
        GrupoResponse grupoResponse = GrupoMapper.toResponsefrom(gravarGrupo.executar(grupo));
        return ResponseEntity.created(UriUtils.generateResourceUriLocation(uriComponentsBuilder, "/api/grupo/{id}", grupoResponse.getId())).body(grupoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoResponse> findById(@PathVariable Long id) {
        Grupo grupo = buscarGrupoPorId.executar(id);
        GrupoResponse grupoResponse = GrupoMapper.toResponsefrom(grupo);
        return ResponseEntity.ok().body(grupoResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity generatePortion(@PathVariable Long id) {
        gerarParcelasPorGrupo.executar(id);
        return ResponseEntity.noContent().build();
    }

}
