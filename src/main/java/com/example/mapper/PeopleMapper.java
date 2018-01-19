package com.example.Mapper;

import com.example.entity.People;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * FileName: PeopleMapper
 *
 * @author gcg
 * @create 2017/12/06 15:35
 * Description: Mybatis People mapper
 * History:
 **/
@Mapper
public interface PeopleMapper {

    @Insert(value = "insert into people(name, age) values (#{name}, #{age})")
    void savePeople(People people);

    @Select(value = "select * from people")
    List<People> findPeopleList();

    @Insert(value = "insert into people(name, age) values (#{name}, #{age})")
    int savePeopleMap(Map<String, Object> map);

    @Delete(value = "delete from people where id = #{id}")
    int deletePeople(int id);

    @Update(value = "update people set #if($!_parameter.name)name = #{name, jdbcType=VARCHAR} #end #if($!_parameter.age),age = @{age, jdbcType=INTEGER} #end where id = #{id, jdbcType=INTEGER}")
    int updatePeopleMap(Map<String, Object> map);
}
