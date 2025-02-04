package com.jhenriquedsm.werbservice_mongodb.config;

import com.jhenriquedsm.werbservice_mongodb.domain.User;
import com.jhenriquedsm.werbservice_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User jose = new User(null, "José", "jose@email.com");
        User henrique = new User(null, "Henrique", "henrique@email.com");
        User joseHenrique = new User(null, "José Henrique", "jose.henrique@email.com");

        userRepository.saveAll(Arrays.asList(jose, henrique, joseHenrique));
    }
}