package com.coolparty.restaurant.repository;

import com.coolparty.restaurant.model.pojo.User;
import com.coolparty.restaurant.service.CRUDService;

public interface UserDao extends CRUDService<User> {

    User findByEmail(String email);
    boolean isEmailUsed(String email);

}
