package org.example.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dto.CreateUserDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();

    public Long create(CreateUserDto createUserDto) {
        return 0L;
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
