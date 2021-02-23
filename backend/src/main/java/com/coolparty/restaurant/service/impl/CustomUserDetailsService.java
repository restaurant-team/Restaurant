//package com.coolparty.restaurant.service.impl;
//
//import com.coolparty.restaurant.model.User;
//import com.coolparty.restaurant.repository.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userDao.findByEmail(email);
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        //TODO process role
//        return null;
//    }
//}
