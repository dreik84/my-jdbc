package org.example.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;

    public UserDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
