package io.github.xNicolosox.spring_data.domain.repository;
import io.github.xNicolosox.spring_data.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
}
