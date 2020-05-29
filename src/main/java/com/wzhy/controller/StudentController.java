package com.wzhy.controller;

import com.wzhy.mapper.StudentMapper;
import com.wzhy.pojo.RespBean;
import com.wzhy.pojo.Student;
import com.wzhy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
//查询学生信息
    @GetMapping("/getStudentById")
    public RespBean getStudentById(String id) {
        id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        System.out.println(id);
        Student student = studentMapper.getStudentById(id);
        if (student != null) {
            return RespBean.ok("获取学生用户信息", student);
        } else {
            return RespBean.error("无法查到用户");
        }
    }}
