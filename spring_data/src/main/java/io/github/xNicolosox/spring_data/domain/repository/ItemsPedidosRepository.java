package io.github.xNicolosox.spring_data.domain.repository;
import io.github.xNicolosox.spring_data.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedidosRepository extends JpaRepository<ItemPedido, Integer> {
}
