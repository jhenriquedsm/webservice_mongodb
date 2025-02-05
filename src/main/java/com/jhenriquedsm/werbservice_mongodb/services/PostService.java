package com.jhenriquedsm.werbservice_mongodb.services;

import com.jhenriquedsm.werbservice_mongodb.domain.Post;
import com.jhenriquedsm.werbservice_mongodb.repository.PostRepository;
import com.jhenriquedsm.werbservice_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}