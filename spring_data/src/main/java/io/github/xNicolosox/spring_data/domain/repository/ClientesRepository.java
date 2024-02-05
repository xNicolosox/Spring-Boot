package io.github.xNicolosox.spring_data.domain.repository;

import io.github.xNicolosox.spring_data.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);
}
