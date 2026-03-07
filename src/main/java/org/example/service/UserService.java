package org.example.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dao.UserDao;
import org.example.dto.CreateUserDto;
import org.example.entity.User;
import org.example.mapper.CreateUserMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserDao userDao = UserDao.getInstance();

    public Long create(CreateUserDto createUserDto) {
        User user = createUserMapper.mapFrom(createUserDto);
        userDao.save(user);

        return user.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
