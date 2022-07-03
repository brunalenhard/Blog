package com.blog.blogservice.api.v1;

import com.blog.blogservice.api.v1.model.request.PostRequest;
import com.blog.blogservice.api.v1.response.PostResponse;
import com.blog.blogservice.mapper.PostMapper;
import com.blog.blogservice.model.domain.Post;
import com.blog.blogservice.model.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/posts")
public class PostResource {
    private final PostService postService;
    private final PostMapper postMapper;

    @PostMapping
    private PostResponse save(@RequestBody @Valid PostRequest postRequest) {
        Post save = postService.save(postMapper.postRequestToPost(postRequest));
        return postMapper.postToPostResponse(save);
    }

    @GetMapping
    public Page<PostResponse> findAll(Pageable pageable){
        return postService.findAll(pageable).map(postMapper::postToPostResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        postService.delete(id);
    }

    @GetMapping("/{id}")
    public PostResponse findById(@PathVariable String id){
        Post post = postService.findByid(id);
        return postMapper.postToPostResponse(post);
    }
}
