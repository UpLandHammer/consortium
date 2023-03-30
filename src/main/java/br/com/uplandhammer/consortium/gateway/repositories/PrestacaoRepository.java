package br.com.uplandhammer.consortium.gateway.repositories;

import br.com.uplandhammer.consortium.gateway.entity.Prestacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestacaoRepository extends JpaRepository<Prestacao, Long> {
}
