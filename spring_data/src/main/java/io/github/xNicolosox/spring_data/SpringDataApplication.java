package io.github.xNicolosox.spring_data;

import io.github.xNicolosox.spring_data.domain.entity.Cliente;
import io.github.xNicolosox.spring_data.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataApplication {

	@Bean
	public CommandLineRunner init (@Autowired ClientesRepository clientes){
		return args -> {
			System.out.println("Salvando clientes...");
			clientes.salvar(new Cliente("Nicolas"));
			clientes.salvar(new Cliente("Douglas"));
			List<Cliente> todosClientes = clientes.obter();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes...");
			todosClientes.forEach(c->{
				c.setNome(c.getNome() + " atualizado");
				clientes.atualizar(c);
			});
			todosClientes = clientes.obter();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes...");
			clientes.buscarPorNome("N").forEach(System.out::println);

			System.out.println("Deletando clientes...");
			clientes.obter().forEach(c->{
				clientes.deletar(c);
			});

			todosClientes = clientes.obter();
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
