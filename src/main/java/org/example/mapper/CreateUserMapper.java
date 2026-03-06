package org.example.mapper;

import org.example.dto.CreateUserDto;
import org.example.entity.Gender;
import org.example.entity.Role;
import org.example.entity.User;

public class CreateUserMapper implements Mapper<User, CreateUserDto> {
    @Override
    public User from(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
//                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }
}
