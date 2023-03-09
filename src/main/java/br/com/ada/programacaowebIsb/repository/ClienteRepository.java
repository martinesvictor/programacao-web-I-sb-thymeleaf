package br.com.ada.programacaowebIsb.repository;

import br.com.ada.programacaowebIsb.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpfContaining(String cpf);

}