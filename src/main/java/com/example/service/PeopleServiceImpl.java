package com.example.service;

import com.example.Mapper.PeopleMapper;
import com.example.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * FileName: PeopleServiceImpl
 *
 * @author gcg
 * @create 2017/12/06 15:24
 * Description: people ServiceImpl demo
 * History:
 **/
@Service(value = "peopleService")
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public void savePeople(People people) {
        this.peopleMapper.savePeople(people);
    }

    @Override
    public List<People> findPeopleList() {
        return this.peopleMapper.findPeopleList();
    }

    @Override
    public int savePeople(Map<String, Object> map) {
        return this.peopleMapper.savePeopleMap(map);
    }

    @Override
    public int detelePeople(int id) {
        return this.peopleMapper.deletePeople(id);
    }

    @Override
    public int updatePeople(Map<String, Object> map) {
        return this.peopleMapper.updatePeopleMap(map);
    }

    @Override
    public void saveAndDelete(People people, int id) throws Exception {
        this.peopleMapper.savePeople(people);
        this.peopleMapper.deletePeople(id);
    }
}
