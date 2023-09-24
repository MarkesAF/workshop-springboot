package com.marques.projeto.config;

import com.marques.projeto.entities.*;
import com.marques.projeto.enums.PedidoStatus;
import com.marques.projeto.repository.*;
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

    @Autowired
    private CategoriaRepository catRepostory;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoItemRepository piRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria c1 = new Categoria(null, "Eletronicos");
        Categoria c2 = new Categoria(null, "Livros");
        Categoria c3 = new Categoria(null, "Computadores");

        catRepostory.saveAll(Arrays.asList(c1,c2,c3));

        Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));

        pr1.getCategorias().add(c2);
        pr2.getCategorias().add(c1);
        pr2.getCategorias().add(c3);
        pr3.getCategorias().add(c3);
        pr4.getCategorias().add(c3);
        pr5.getCategorias().add(c2);

        produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));

        User u1 = new User(null, "Alex", "alex@gmail.com","98233445","password");
        User u2 = new User(null, "Bob", "bob@gmail.com","88252345","senha");


        Pedido p1 = new Pedido(null, Instant.parse("2023-07-20T19:02:20Z"), PedidoStatus.PAID,u1);
        Pedido p2 = new Pedido(null, Instant.parse("2023-05-10T15:08:20Z"),PedidoStatus.WAITING_PAYMENT,u2);
        Pedido p3 = new Pedido(null, Instant.parse("2022-11-30T21:02:20Z"),PedidoStatus.PAID,u1);

        rep.saveAll(Arrays.asList(u1,u2));
        repository.saveAll(Arrays.asList(p1,p2,p3));



        PedidoItem pi1 = new PedidoItem(p1,pr1,2,pr1.getPreco());
        PedidoItem pi2 = new PedidoItem(p1,pr3,1,pr3.getPreco());
        PedidoItem pi3 = new PedidoItem(p2,pr3,2,pr1.getPreco());
        PedidoItem pi4 = new PedidoItem(p3,pr5,2,pr5.getPreco());

        piRepository.saveAll(Arrays.asList(pi1,pi2,pi3,pi4));


        Pagamento pag1 = new Pagamento(null,Instant.parse("2023-07-21T23:02:20Z"),p1);
        p1.setPagamento(pag1);
        repository.save(p1);
    }

}
