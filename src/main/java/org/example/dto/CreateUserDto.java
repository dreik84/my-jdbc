package org.example.dto;

import lombok.Value;

@Value
public final class CreateUserDto {
    private final String name;
    private final String birthday;
    private final String email;
    private final String password;
    private final String role;
    private final String gender;

    CreateUserDto(String name, String birthday, String email, String password, String role, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
    }

    public static CreateUserDtoBuilder builder() {
        return new CreateUserDtoBuilder();
    }

    public static class CreateUserDtoBuilder {
        private String name;
        private String birthday;
        private String email;
        private String password;
        private String role;
        private String gender;

        CreateUserDtoBuilder() {
        }

        public CreateUserDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CreateUserDtoBuilder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public CreateUserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public CreateUserDtoBuilder password(String password) {
            this.password = password;
            return this;
        }

        public CreateUserDtoBuilder role(String role) {
            this.role = role;
            return this;
        }

        public CreateUserDtoBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public CreateUserDto build() {
            return new CreateUserDto(this.name, this.birthday, this.email, this.password, this.role, this.gender);
        }

        public String toString() {
            return "CreateUserDto.CreateUserDtoBuilder(name=" + this.name + ", birthday=" + this.birthday + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ", gender=" + this.gender + ")";
        }
    }
}
