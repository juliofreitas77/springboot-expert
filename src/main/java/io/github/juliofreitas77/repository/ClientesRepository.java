package io.github.juliofreitas77.repository;

import io.github.juliofreitas77.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeLike(String nome);
}
