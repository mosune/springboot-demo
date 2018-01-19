package com.example.repository;

import com.example.entity.Teacher;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FileName: TeacherRepository
 * Author:   gcg
 * Date:     2017/12/1 16:06
 * Description: TeacherRepository jpa test
 * History:
 */
@Repository
public interface TeacherRepository /*extends JpaRepository<Teacher, Long>*/ {

    List<Teacher> findByName(String name);

    List<Teacher> findByNameAndAge(String name, Integer age);

    /*@Query("from Teacher u where u.name=:name")
    Teacher findUser(@Param("name") String name);*/

}
