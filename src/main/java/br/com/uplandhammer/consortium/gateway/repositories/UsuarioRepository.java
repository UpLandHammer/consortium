package br.com.uplandhammer.consortium.gateway.repositories;

import br.com.uplandhammer.consortium.gateway.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<List<Usuario>> findByEmailOrNomeOrTelefone(String email, String nome, String telefone);

}
