package com.coolparty.restaurant.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

//    private UserDaoImpl userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        return null;
    }
}
