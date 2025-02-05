package com.jhenriquedsm.werbservice_mongodb.repository;

import com.jhenriquedsm.werbservice_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}