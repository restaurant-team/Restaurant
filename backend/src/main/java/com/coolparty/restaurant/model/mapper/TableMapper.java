package com.coolparty.restaurant.model.mapper;

import com.coolparty.restaurant.model.pojo.Table;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TableMapper implements RowMapper<Table> {
    @Override
    public Table mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Table table = new Table();
        table.setId(UUID.fromString(resultSet.getString("id")));
        table.setRestaurantId(resultSet.getInt("id_restaurant"));
        table.setTableNumber(resultSet.getInt("table_number"));
        table.setCapacity(resultSet.getInt("capacity"));
        table.setNotes(resultSet.getString("notes"));
        return table;
    }
}
