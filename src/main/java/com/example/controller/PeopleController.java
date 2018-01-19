package com.example.controller;

import com.example.exception.MyException;
import com.example.service.PeopleService;
import com.example.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * FileName: PeopleController
 *
 * @author gcg
 * @create 2017/12/06 15:43
 * Description: Mybatis People Controller
 * History:
 **/
@RestController
@RequestMapping(value = "people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value = "savePeople")
    public String savePeople(People people) {
        this.peopleService.savePeople(people);
        return "success";
    }

    @RequestMapping(value = "peopleList", method = RequestMethod.POST)
    public List<People> findPeopleList() {
        return this.peopleService.findPeopleList();
    }

    @RequestMapping(value = "savePeopleMap", method = RequestMethod.POST)
    public int savePeople(@RequestParam Map<String, Object> map) {
        return this.peopleService.savePeople(map);
    }

    @RequestMapping(value = "deletePeople", method = RequestMethod.DELETE)
    public int deletePeople(int id) {
        return this.peopleService.detelePeople(id);
    }

    @RequestMapping(value = "updatePeople", method = RequestMethod.POST)
    public int updatePeople(@RequestParam Map<String, Object> map) throws Exception {
        if (!map.containsKey("id") || map.get("id") == null) {
            throw new MyException("I'm so sorry, you should give a id");
        }
        return this.peopleService.updatePeople(map);
    }

    @RequestMapping(value = "saveAndDelete", method = RequestMethod.POST)
    public String saveAndDeletePeople(People people, int deleId) throws Exception {
        this.peopleService.saveAndDelete(people, deleId);
        return "success";
    }

}
