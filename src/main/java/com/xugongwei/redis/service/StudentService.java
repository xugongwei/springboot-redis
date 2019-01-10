package com.xugongwei.redis.service;

import com.xugongwei.redis.entity.Student;
import com.xugongwei.redis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 徐功伟
 * @date 2019-01-08 17:38
 */
@Service
@CacheConfig(cacheNames = "student_info")
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据id获取指定的学生，并放入到缓存中
     *
     * @param id 学生id
     * @return 学生
     */
    @Cacheable(key = "'student_'+#id")
    public Student getStudent(Long id) {
        return studentMapper.queryObject(id);
    }

    @Cacheable(key = "#root.method.name")
    public List<Student> listStudent(Map<String, Object> map) {
        return studentMapper.queryList(map);
    }

    @CacheEvict(key = "'student_' +#id")
    public Integer deleteStudent(Long id) {
        return studentMapper.delete(id);
    }

    @CachePut(key = "'student_'+#result.id")
    public Student updateStudent(Student student) {
        studentMapper.update(student);
        return student;
    }

    public Student insertStudent(Student student) {
        studentMapper.save(student);
        return student;
    }
}
