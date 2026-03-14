package org.example.dto;

import lombok.Builder;
import lombok.Value;
import org.example.entity.Gender;
import org.example.entity.Role;

import java.time.LocalDate;

@Value
//@Builder
public final class UserDto {
    private final Long id;
    private final String name;
    private final LocalDate birthday;
    private final String email;
    private final String password;
    private final Role role;
    private final Gender gender;

    UserDto(Long id, String name, LocalDate birthday, String email, String password, Role role, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public static UserDtoBuilder builder() {
        return new UserDtoBuilder();
    }

    public static class UserDtoBuilder {
        private Long id;
        private String name;
        private LocalDate birthday;
        private String email;
        private String password;
        private Role role;
        private Gender gender;

        UserDtoBuilder() {
        }

        public UserDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserDtoBuilder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDtoBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDtoBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserDtoBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserDto build() {
            return new UserDto(this.id, this.name, this.birthday, this.email, this.password, this.role, this.gender);
        }

        public String toString() {
            return "UserDto.UserDtoBuilder(id=" + this.id + ", name=" + this.name + ", birthday=" + this.birthday + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ", gender=" + this.gender + ")";
        }
    }
}
