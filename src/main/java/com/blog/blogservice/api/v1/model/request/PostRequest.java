package com.blog.blogservice.api.v1.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    @NotEmpty
    private String content;
    @NotEmpty
    private String title;
}
