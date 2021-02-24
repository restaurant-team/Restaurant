package com.coolparty.restaurant.model.mapper;

import com.coolparty.restaurant.model.pojo.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DishMapper implements RowMapper<Dish> {
    @Override
    public Dish mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Dish dish = new Dish();
        dish.setId(UUID.fromString(resultSet.getString("id")));
        dish.setDishTypeId(resultSet.getInt("id_dish_type"));
        dish.setName(resultSet.getString("name"));
        dish.setPrice(resultSet.getInt("price"));
        dish.setDescription(resultSet.getString("description"));
        return dish;
    }
}
