package com.xugongwei.redis.mapper;

import com.xugongwei.redis.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author 徐功伟
 * @date 2019-01-08 17:31
 */
public interface StudentMapper {

    Student selectObject(Long id);

    List<Student> selectList(Map<String,Object> map);

    Integer deleteStudent(Long id);

    Integer updateStudent(Student student);

    Integer insertStudent(Student student);
}
