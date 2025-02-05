package com.jhenriquedsm.werbservice_mongodb.repository;

import com.jhenriquedsm.werbservice_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}