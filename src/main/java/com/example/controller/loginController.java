package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName: loginController
 *
 * @author gcg
 * @create 2017/12/11 16:09
 * Description: security contrller demo
 * History:
 **/
@Controller
public class loginController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

}
