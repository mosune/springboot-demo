package com.example.controller;

import com.example.service.UserService;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * FileName: UserJdbcController
 * Author:   gcg
 * Date:     2017/12/1 14:37
 * Description: JdbcTemplate demo
 * History:
 */
@RestController
@RequestMapping("/jdbcUser")
public class UserJdbcController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String createUser(User user) {
        this.userService.create(user.getName(), user.getAge());
        return "success";
    }

    @RequestMapping(value = "/deleteAllUser", method = RequestMethod.DELETE)
    public String delateAllUser() {
        this.userService.deleteAllUsers();
        return "success";
    }

    @RequestMapping(value = "deleteUserById", method = RequestMethod.DELETE)
    public String deleteUser(Long id) {
        this.userService.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "getUserCount", method = RequestMethod.GET)
    public Integer getUserCount() {
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "getUserLists", method = RequestMethod.GET)
    public List<Map<String, Object>> getUserLists() {
        return this.userService.getUsersLists();
    }

}
