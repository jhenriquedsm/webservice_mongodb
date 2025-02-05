package com.jhenriquedsm.werbservice_mongodb.config;

import com.jhenriquedsm.werbservice_mongodb.domain.Post;
import com.jhenriquedsm.werbservice_mongodb.domain.User;
import com.jhenriquedsm.werbservice_mongodb.dto.AuthorDTO;
import com.jhenriquedsm.werbservice_mongodb.repository.PostRepository;
import com.jhenriquedsm.werbservice_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final SimpleDateFormat sdf;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public Instantiation() {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User jose = new User(null, "José", "jose@email.com");
        User henrique = new User(null, "Henrique", "henrique@email.com");
        User joseHenrique = new User(null, "José Henrique", "jose.henrique@email.com");

        userRepository.saveAll(Arrays.asList(jose, henrique, joseHenrique));

        Post post1 = new Post(null, sdf.parse("05/02/2025"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(henrique));
        Post post2 = new Post(null, sdf.parse("05/02/2025"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(henrique));

        postRepository.saveAll(Arrays.asList(post1, post2));

        henrique.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(henrique);
    }
}