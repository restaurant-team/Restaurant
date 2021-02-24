package com.coolparty.restaurant.model.mapper;

import com.coolparty.restaurant.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        User user = new User();
        user.setId(UUID.fromString(resultSet.getString("id")));
        user.setRoleId(resultSet.getInt("id_role"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setSurname(resultSet.getString("surname"));
        user.setName(resultSet.getString("name"));
        return user;
    }
}
