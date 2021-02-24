package com.coolparty.restaurant.repository.impl;

import com.coolparty.restaurant.model.mapper.DishMapper;
import com.coolparty.restaurant.model.pojo.Dish;
import com.coolparty.restaurant.repository.DishDao;
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
@PropertySource("classpath:sql/dish_queries.properties")
public class DishDaoImpl implements DishDao {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Value("${insert_dish}")
    private String insertDish;
    @Value("${find_dish_by_id}")
    private String findDishById;
    @Value("${find_all_dishes}")
    private String findAllDishes;
    @Value("${update_dish}")
    private String updateDish;
    @Value("${delete_dish}")
    private String deleteDish;



    @Override
    public Dish find(Object id) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
        return this.template.queryForObject(findDishById, param, new DishMapper());
    }

    @Override
    public List<Dish> findAll() {
        return this.template.query(findAllDishes, new DishMapper());
    }

    @Override
    public Dish create(Dish dish) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id_dish_type", dish.getDishTypeId())
                .addValue("name", dish.getName())
                .addValue("price", dish.getPrice())
                .addValue("description", dish.getDescription());
        template.update(insertDish, param, holder);
        UUID generatedId = UUID.fromString(String.valueOf(holder.getKeyList().get(0).get("id")));
        return find(generatedId);
    }

    @Override
    public Dish update(Dish dish) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", dish.getId())
                .addValue("id_dish_type", dish.getDishTypeId())
                .addValue("name", dish.getName())
                .addValue("price", dish.getPrice())
                .addValue("description", dish.getDescription());
        this.template.update(updateDish, param);
        return find(dish.getId());
    }

    @Override
    public void delete(Object id) {
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        template.update(deleteDish, param);
    }
}
