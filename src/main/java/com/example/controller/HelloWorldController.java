package com.example.controller;

import com.example.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
    public String index() throws Exception {
	    throw new Exception("草拟吗");
    }

    @RequestMapping("/")
    public String test(ModelMap modelMap) {
        modelMap.put("host", "www.baidu.com");
        return "index";
    }

    @RequestMapping("/jsonError")
    public String jsonException() throws Exception {
        throw new MyException("I'm sorry");
    }
	
}
