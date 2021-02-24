package com.coolparty.restaurant.service.impl;

import com.coolparty.restaurant.error.EmailIsUsedException;
import com.coolparty.restaurant.model.pojo.User;
import com.coolparty.restaurant.model.dto.LoginDto;
import com.coolparty.restaurant.repository.UserDao;
import com.coolparty.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(LoginDto loginDto) {
        return null;
    }

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
        if (userDao.isEmailUsed(user.getEmail())){
            throw new EmailIsUsedException();
        }
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }
}
