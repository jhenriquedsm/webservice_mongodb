package com.jhenriquedsm.werbservice_mongodb.resources;

import com.jhenriquedsm.werbservice_mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user = new User("1", "José", "jose@email.com");
        User user1 = new User("2", "Henrique", "henrique@email.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(user, user1));
        return ResponseEntity.ok().body(users);
    }
}