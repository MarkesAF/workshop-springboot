package com.marques.projeto.config;

import com.marques.projeto.entities.Pedido;
import com.marques.projeto.entities.User;
import com.marques.projeto.enums.PedidoStatus;
import com.marques.projeto.repository.PedidoRepository;
import com.marques.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository rep;

    @Autowired
    private PedidoRepository repository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Alex", "alex@gmail.com","98233445","password");
        User u2 = new User(null, "Bob", "bob@gmail.com","88252345","senha");


        Pedido p1 = new Pedido(null, Instant.parse("2023-07-20T19:02:20Z"), PedidoStatus.DELIVERED,u1);
        Pedido p2 = new Pedido(null, Instant.parse("2023-05-10T15:08:20Z"),PedidoStatus.CANCEL,u2);
        Pedido p3 = new Pedido(null, Instant.parse("2022-11-30T21:02:20Z"),PedidoStatus.PAID,u1);

        rep.saveAll(Arrays.asList(u1,u2));
        repository.saveAll(Arrays.asList(p1,p2,p3));
    }

}
