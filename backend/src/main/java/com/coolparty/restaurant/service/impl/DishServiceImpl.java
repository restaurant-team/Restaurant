package com.coolparty.restaurant.service.impl;

import com.coolparty.restaurant.model.pojo.Dish;
import com.coolparty.restaurant.repository.DishDao;
import com.coolparty.restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishDao dishDao;

    @Override
    public Dish find(Object id) {
        return dishDao.find(id);
    }

    @Override
    public List<Dish> findAll() {
        return dishDao.findAll();
    }

    @Override
    public Dish create(Dish dish) {
        return dishDao.create(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return dishDao.update(dish);
    }

    @Override
    public void delete(Object id) {
        dishDao.delete(id);
    }
}
