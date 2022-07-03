package com.blog.blogservice.model.service;

import com.blog.blogservice.model.domain.Post;
import com.blog.blogservice.model.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post findByid(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado!"));
    }

    public void delete(String id) {
        postRepository.deleteById(id);
    }
}
