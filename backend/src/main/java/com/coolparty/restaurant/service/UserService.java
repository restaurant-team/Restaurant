package com.coolparty.restaurant.service;

import com.coolparty.restaurant.model.User;
import com.coolparty.restaurant.model.dto.LoginDto;

public interface UserService extends CRUDService<User> {

    User login(LoginDto loginDto);

    void register(User user);
}
