package com.coolparty.restaurant.repository;

import com.coolparty.restaurant.model.pojo.Restaurant;
import com.coolparty.restaurant.model.pojo.Table;
import com.coolparty.restaurant.service.CRUDService;

import java.time.LocalDateTime;
import java.util.List;

public interface RestaurantDao extends CRUDService<Restaurant> {

    List<Table> getAvailableTables(LocalDateTime from, LocalDateTime to, int restaurantId, int capacity);

}
