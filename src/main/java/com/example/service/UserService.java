package com.example.service;

import java.util.List;
import java.util.Map;

/**
 * FileName: UserService
 * Author:   gcg
 * Date:     2017/12/1 14:23
 * Description: UserService JdbcTemplate demo
 * History:
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据id删除一个用户高
     * @param id
     */
    void deleteById(Long id);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 返回所有用户
     * @return
     */
    List<Map<String, Object>> getUsersLists();

}
