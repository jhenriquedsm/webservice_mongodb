package com.jhenriquedsm.werbservice_mongodb.repository;

import com.jhenriquedsm.werbservice_mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

}