package com.coolparty.restaurant.service;

import com.coolparty.restaurant.model.pojo.User;
import com.coolparty.restaurant.model.dto.LoginDto;

public interface UserService extends CRUDService<User> {

    User login(LoginDto loginDto);

}
