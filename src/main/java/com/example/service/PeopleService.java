package com.example.service;

import com.example.entity.People;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * FileName: PeopleService
 *
 * @author gcg
 * @create 2017/12/06 15:20
 * Description: people service demo
 * History:
 **/
public interface PeopleService {

    void savePeople(People people);

    List<People> findPeopleList();

    int savePeople(Map<String, Object> map);

    int detelePeople(int id);

    int updatePeople(Map<String, Object> map);

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    void saveAndDelete(People people, int id) throws Exception;
}
