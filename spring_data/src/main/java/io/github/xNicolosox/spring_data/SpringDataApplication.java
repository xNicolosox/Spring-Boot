package io.github.xNicolosox.spring_data;
import io.github.xNicolosox.spring_data.domain.entity.Cliente;
import io.github.xNicolosox.spring_data.domain.entity.Pedido;
import io.github.xNicolosox.spring_data.domain.repository.ClientesRepository;
import io.github.xNicolosox.spring_data.domain.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication {

	@Bean
	public CommandLineRunner init (@Autowired ClientesRepository clientes,
								   @Autowired PedidosRepository pedidos){
		return args -> {
			System.out.println("Salvando clientes...");
			Cliente fulano = new Cliente("fulano");
			clientes.save(fulano);
			clientes.save(new Cliente("Nicolas"));
			clientes.save(new Cliente("Douglas"));
			clientes.save(new Cliente ("maria") );

			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			pedidos.save(p);
//			Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//			System.out.println(cliente);
//			System.out.println(cliente.getPedidos());
			 pedidos.findByCliente(fulano).forEach(System.out::println);



			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			boolean existe = clientes.existsByNome("Douglas");
			System.out.println("Existe um nome Douglas?" + existe);

			System.out.println("Atualizando clientes...");
			todosClientes.forEach(c->{
				c.setNome(c.getNome() + " atualizado");
				clientes.save(c);
			});
			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes...");
			List <Cliente> result = clientes.encontrarPorNome("N");
			result.forEach(System.out::println);

			System.out.println("Deletando clientes...");
			clientes.findAll().forEach(c->{
				clientes.delete(c);
			});

			todosClientes = clientes.findAll();
			if (todosClientes.isEmpty()) {
				System.out.println("Nao existe clientes registados");
			} else {
				todosClientes.forEach(System.out::println);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

}
