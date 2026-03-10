package org.example.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dto.CreateUserDto;
import org.example.entity.Gender;
import org.example.entity.Role;
import org.example.util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto userDto) {
        var validationResult = new ValidationResult();

        if (!LocalDateFormatter.isValid(userDto.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (Gender.find(userDto.getGender()).isEmpty()) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        if (Role.find(userDto.getRole()).isEmpty()) {
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
