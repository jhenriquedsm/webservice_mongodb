package com.jhenriquedsm.werbservice_mongodb.services;

import com.jhenriquedsm.werbservice_mongodb.domain.User;
import com.jhenriquedsm.werbservice_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}