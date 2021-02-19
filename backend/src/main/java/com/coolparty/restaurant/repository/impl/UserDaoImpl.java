package com.coolparty.restaurant.repository.impl;

import com.coolparty.restaurant.model.User;
import com.coolparty.restaurant.repository.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User find(Object id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }
}
