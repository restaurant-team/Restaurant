package com.coolparty.restaurant.model.mapper;

import com.coolparty.restaurant.model.pojo.Reservation;
import com.coolparty.restaurant.utils.TimeUtility;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class ReservationMapper implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(UUID.fromString(resultSet.getString("id")));
        reservation.setTableId(UUID.fromString(resultSet.getString("id_table")));
        reservation.setName(resultSet.getString("name"));
        reservation.setEmail(resultSet.getString("email"));
        reservation.setReservedFrom(TimeUtility.convertToLocalDateTime(resultSet.getTimestamp("reserved_from")));
        reservation.setReservedTo(TimeUtility.convertToLocalDateTime(resultSet.getTimestamp("reserved_to")));
        return reservation;
    }
}
