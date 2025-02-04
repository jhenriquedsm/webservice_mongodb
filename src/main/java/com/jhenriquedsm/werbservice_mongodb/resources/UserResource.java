package com.jhenriquedsm.werbservice_mongodb.resources;

import com.jhenriquedsm.werbservice_mongodb.domain.User;
import com.jhenriquedsm.werbservice_mongodb.dto.UserDTO;
import com.jhenriquedsm.werbservice_mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(usersDTO);
    }
}