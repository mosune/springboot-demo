package com.example.controller;

import com.example.repository.TeacherRepository;
import com.example.entity.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FileName: TeacherController
 * Author:   gcg
 * Date:     2017/12/1 16:12
 * Description: TeacherController Jpa Test
 * History:
 */
@RestController
@RequestMapping(value = "teacher")
public class TeacherController {

    // @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping(value = "/getUserByName", method = RequestMethod.POST)
    public List<Teacher> getUserByName(String name) {
        List<Teacher> teachers = this.teacherRepository.findByName(name);
        return teachers;
    }

    @RequestMapping(value = "/getUserByNameAndAge", method = RequestMethod.POST)
    public List<Teacher> getUserByNameAndAge(String name, Integer age) {
        List<Teacher> teachers = this.teacherRepository.findByNameAndAge(name, age);
        return teachers;
    }

}
