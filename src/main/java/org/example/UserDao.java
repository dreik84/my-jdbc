package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {
    private Connection connection;

    public UserDao(Connection conn) {
        connection = conn;
    }

    public void save(User user) throws SQLException {
        // insert
        if (user.getId() == null) {
            var sql = "INSERT INTO users (username, phone) VALUES (?, ?)";

            try (var prepareStatement = connection.prepareStatement(sql)) {
                prepareStatement.setString(1, user.getName());
                prepareStatement.setString(2, user.getPhone());
                prepareStatement.executeUpdate();

                var generatedKey = prepareStatement.getGeneratedKeys();

                if (generatedKey.next()) {
                    user.setId(generatedKey.getLong("id"));
                } else {
                    throw new SQLException("DB have not returned a id after saving");
                }
            }
        } else {
            var sql = "UPDATE users SET username = ?, phone = ? WHERE id = ?";

            try (var prepareStatement = connection.prepareStatement(sql)) {
                prepareStatement.setString(1, user.getName());
                prepareStatement.setString(2, user.getPhone());
                prepareStatement.setLong(3, user.getId());
                prepareStatement.executeUpdate();
            }
        }
    }

    public Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";

        try (var stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                var username = resultSet.getString("username");
                var phone = resultSet.getString("phone");
                var user = new User(username, phone);
                user.setId(id);

                return Optional.of(user);
            }
            return Optional.empty();
        }
    }
}
