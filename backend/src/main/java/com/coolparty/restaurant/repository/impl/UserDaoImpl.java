package com.coolparty.restaurant.repository.impl;

import com.coolparty.restaurant.model.User;
import com.coolparty.restaurant.model.mapper.UserMapper;
import com.coolparty.restaurant.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:sql/user_queries.properties")
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Value("${insert_user}")
    private String insertUser;
    @Value("${find_user_by_email}")
    private String findUserByEmail;
    @Value("${is_email_used}")
    private String isEmailUsed;

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
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id_role", user.getRoleId())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("surname", user.getSurname())
                .addValue("name", user.getName());
        template.update(insertUser, param);
        return findByEmail(user.getEmail());
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public User findByEmail(String email) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("email", email);
        return this.template.queryForObject(findUserByEmail, param, new UserMapper());
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean isEmailUsed(final String email) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("email", email);
        int count = this.template.queryForObject(isEmailUsed, param, Integer.class);
        return count != 0;
    }
}
