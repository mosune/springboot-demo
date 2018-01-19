package com.example.entity;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/

/**
 * FileName: Teacher
 * Author:   gcg
 * Date:     2017/12/1 15:54
 * Description: jpa teacher test
 * History:
 */
// @Entity
public class Teacher {

    /*@Id
    @GeneratedValue*/
    private Long id;

    // @Column(nullable = false)
    private String name;

    // @Column(nullable = false)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
