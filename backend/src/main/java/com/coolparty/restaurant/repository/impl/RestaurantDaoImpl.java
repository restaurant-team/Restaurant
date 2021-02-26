package com.coolparty.restaurant.repository.impl;

import com.coolparty.restaurant.model.mapper.RestaurantMapper;
import com.coolparty.restaurant.model.mapper.TableMapper;
import com.coolparty.restaurant.model.pojo.Restaurant;
import com.coolparty.restaurant.model.pojo.Table;
import com.coolparty.restaurant.repository.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@PropertySource("classpath:sql/restaurant_queries.properties")
public class RestaurantDaoImpl implements RestaurantDao {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Value("${find_all_restaurants}")
    private String findAllRestaurants;
    @Value("${find_available_tables}")
    private String findAvailableTables;


    @Override
    public Restaurant find(Object id) {
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        return this.template.query(findAllRestaurants, new RestaurantMapper());
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    public List<Table> getAvailableTables(LocalDateTime from, LocalDateTime to, int restaurantId, int capacity) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("reserved_from", from)
                .addValue("reserved_to", to)
                .addValue("id_restaurant", restaurantId)
                .addValue("capacity", capacity);
        return this.template.query(findAvailableTables, param, new TableMapper());
    }
}
