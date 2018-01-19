package com.example.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * FileName: Student
 * Author:   gcg
 * Date:     2017/11/30 13:29
 * Description: Student Test Class
 * History:
 */
@Component
public class Student {

    @Value("${com.example.entity.Student.name}")
    private String name;

    @Value("${com.example.entity.Student.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
