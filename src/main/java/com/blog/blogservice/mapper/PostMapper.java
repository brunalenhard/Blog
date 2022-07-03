package com.blog.blogservice.mapper;

import com.blog.blogservice.api.v1.model.request.PostRequest;
import com.blog.blogservice.api.v1.response.PostResponse;
import com.blog.blogservice.model.domain.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post postRequestToPost(PostRequest postRequest);
    PostResponse postToPostResponse(Post post);
}
