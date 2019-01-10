package com.xugongwei.redis.controller;

import com.xugongwei.redis.entity.Student;
import com.xugongwei.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 徐功伟
 * @date 2019-01-08 17:41
 */
@RestController

public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/get")
    public Map<String, Object> get(@RequestParam Long id) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("student", studentService.getStudent(id));
        return map;
    }

    @GetMapping("/student/list")
    public Map<String, Object> list(Map<String, Object> map) {
        Map<String, Object> students = new HashMap<>(16);
        students.put("students", studentService.listStudent(map));
        return students;
    }

    @DeleteMapping("/student/delete")
    public String delete(@RequestParam Long id) {
        Integer count = studentService.deleteStudent(id);
        return count != 0 ? "删除成功" : "删除失败";
    }

    @PutMapping("/student/update")
    public String update(@RequestBody Student student) {
        Student student1 = studentService.updateStudent(student);
        return student1 != null ? student1.toString() : "更新失败";
    }

    @PostMapping("/student/insert")
    public String insert(@RequestBody Student student) {
        Student stu = studentService.insertStudent(student);
        return stu != null ? stu.toString() : "添加失败";
    }
}
