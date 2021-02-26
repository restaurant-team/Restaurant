package com.coolparty.restaurant.service.impl;

import com.coolparty.restaurant.model.pojo.Restaurant;
import com.coolparty.restaurant.repository.RestaurantDao;
import com.coolparty.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public Restaurant find(Object id) {
        return restaurantDao.find(id);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantDao.findAll();
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
}
