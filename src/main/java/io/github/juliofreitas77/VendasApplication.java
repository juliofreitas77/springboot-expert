package io.github.juliofreitas77;

import io.github.juliofreitas77.entity.Cliente;
import io.github.juliofreitas77.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {
    /*
        @Value("${application.name}")
        private String applicationName;

        @GetMapping(value = "/hello")
        public String helloWorld() {
            return applicationName;
        }
    **/

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepository) {
        return args -> {
            clientesRepository.salvar(new Cliente("Julio Cesar"));
            clientesRepository.salvar(new Cliente("Juan"));

            List<Cliente> todosClientes = clientesRepository.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientesRepository.atualizar(c);
            });

            todosClientes = clientesRepository.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("deletando clientes");
            clientesRepository.obterTodos().forEach(c -> {
                clientesRepository.deletar(c);
            });

            todosClientes = clientesRepository.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado.");
            }else{
                todosClientes.forEach(System.out::println);
            }
        };
    }


        public static void main (String[]args){
            SpringApplication.run(VendasApplication.class, args);
        }
    }