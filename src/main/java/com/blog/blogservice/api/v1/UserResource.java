package com.blog.blogservice.api.v1;

import com.blog.blogservice.api.v1.model.request.UserRequest;
import com.blog.blogservice.api.v1.response.PostResponse;
import com.blog.blogservice.api.v1.response.UserResponse;
import com.blog.blogservice.mapper.UserMapper;
import com.blog.blogservice.model.domain.User;
import com.blog.blogservice.model.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public UserResponse save(@RequestBody @Valid UserRequest userRequest) {
        User save = userService.save(userMapper.userRequestToUser(userRequest));
        return userMapper.userToUserResponse(save);
    }

    @GetMapping
    public Page<UserResponse> findAll(Pageable pageable) {
        return userService.findAll(pageable)
                .map(userMapper::userToUserResponse);
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable String id){
        return userMapper.userToUserResponse(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userService.delete(id);
    }

}
