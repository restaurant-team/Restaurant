package com.coolparty.restaurant.repository.impl;

import com.coolparty.restaurant.model.mapper.DishMapper;
import com.coolparty.restaurant.model.mapper.ReservationMapper;
import com.coolparty.restaurant.model.pojo.Reservation;
import com.coolparty.restaurant.repository.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@PropertySource("classpath:sql/reservation_queries.properties")
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Value("${insert_reservation}")
    private String insertReservation;
    @Value("${find_reservation_by_id}")
    private String findReservationById;

    @Override
    public Reservation find(Object id) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
        return this.template.queryForObject(findReservationById, param, new ReservationMapper());
    }

    @Override
    public List<Reservation> findAll() {
        return null;
    }

    @Override
    public Reservation create(Reservation reservation) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id_table", reservation.getTableId())
                .addValue("name", reservation.getName())
                .addValue("email", reservation.getEmail())
                .addValue("reserved_from", reservation.getReservedFrom())
                .addValue("reserved_to", reservation.getReservedTo());
        template.update(insertReservation, param, holder);
        UUID generatedId = UUID.fromString(String.valueOf(holder.getKeyList().get(0).get("id")));
        return find(generatedId);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }
}
