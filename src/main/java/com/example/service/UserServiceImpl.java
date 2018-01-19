package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * FileName: UserServiceImpl
 * Author:   gcg
 * Date:     2017/12/1 14:27
 * Description: UserServiceImpl JdbcTemplate demo 
 * History:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from USER where ID = ?", id);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(*) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }

    @Override
    public List<Map<String, Object>> getUsersLists() {
        return jdbcTemplate.queryForList("select * FROM USER");
    }

}
