package org.example.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.entity.User;
import org.example.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements Dao<Long, User> {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL =
            "INSERT INTO users(name, birthday, email, password, role, gender) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    @SneakyThrows
    public User save(User user) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setObject(1, user.getName());
            statement.setObject(2, user.getBirthday());
            statement.setObject(3, user.getEmail());
            statement.setObject(4, user.getPassword());
            statement.setObject(5, user.getRole());
            statement.setObject(6, user.getGender());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next())
                user.setId(keys.getObject("id", Long.class));
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
