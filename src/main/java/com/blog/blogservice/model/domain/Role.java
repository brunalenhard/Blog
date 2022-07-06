package com.blog.blogservice.model.domain;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public enum Role implements GrantedAuthority {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
