package com.blog.blogservice.api.v1.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotEmpty(message = "O campo é obrigatório")
    @Min(2)
    private String name;
    @NotEmpty(message = "O campo é obrigatório")
    @Min(6)
    @Max(15)
    private String password;
    @NotEmpty(message = "O campo é obrigatório")
    @Email
    private String email;
}
