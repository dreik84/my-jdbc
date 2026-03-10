package org.example.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dao.UserDao;
import org.example.dto.CreateUserDto;
import org.example.entity.User;
import org.example.exeption.ValidationException;
import org.example.mapper.CreateUserMapper;
import org.example.validator.CreateUserValidator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();

    public Long create(CreateUserDto createUserDto) {
        var validationResult = createUserValidator.isValid(createUserDto);

        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        User user = createUserMapper.mapFrom(createUserDto);
        userDao.save(user);

        return user.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
