package com.blog.blogservice.mapper;

import com.blog.blogservice.api.v1.model.request.UserRequest;
import com.blog.blogservice.api.v1.response.UserResponse;
import com.blog.blogservice.model.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userRequestToUser(UserRequest userRequest);

    UserResponse userToUserResponse(User user);
}
