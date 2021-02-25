package com.coolparty.restaurant.model.mapper;

import com.coolparty.restaurant.model.pojo.Restaurant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements RowMapper<Restaurant> {
    @Override
    public Restaurant mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(resultSet.getInt("id"));
        restaurant.setName(resultSet.getString("name"));
        restaurant.setAddress(resultSet.getString("address"));
        restaurant.setNotes(resultSet.getString("notes"));
        return restaurant;
    }
}
