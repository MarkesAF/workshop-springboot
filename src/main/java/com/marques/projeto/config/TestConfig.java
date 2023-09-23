package com.marques.projeto.config;

import com.marques.projeto.entities.User;
import com.marques.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository rep;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Alex", "alex@gmail.com","98233445","password");
        User u2 = new User(null, "Bob", "bob@gmail.com","88252345","senha");

        rep.saveAll(Arrays.asList(u1,u2));
    }
}
