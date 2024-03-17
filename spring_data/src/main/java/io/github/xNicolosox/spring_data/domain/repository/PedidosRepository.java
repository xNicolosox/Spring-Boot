package io.github.xNicolosox.spring_data.domain.repository;
import io.github.xNicolosox.spring_data.domain.entity.Cliente;
import io.github.xNicolosox.spring_data.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
