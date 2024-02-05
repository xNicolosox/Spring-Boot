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
			clientes.save(new Cliente("Nicolas"));
			clientes.save(new Cliente("Douglas"));
			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes...");
			todosClientes.forEach(c->{
				c.setNome(c.getNome() + " atualizado");
				clientes.save(c);
			});
			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes...");
			clientes.findByNomeLike("N").forEach(System.out::println);

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
