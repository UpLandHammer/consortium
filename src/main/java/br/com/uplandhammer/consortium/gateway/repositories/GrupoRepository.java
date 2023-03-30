package br.com.uplandhammer.consortium.gateway.repositories;

import br.com.uplandhammer.consortium.gateway.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
}
