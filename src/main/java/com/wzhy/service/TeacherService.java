package com.wzhy.service;

import com.wzhy.mapper.TeacherMapper;
import com.wzhy.pojo.Teacher;
import com.wzhy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    public Teacher getTeacherById(String id){
        return teacherMapper.getTeacherById(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
    public int insertTeacher(Teacher teacher){
       return teacherMapper.insertTeacher(teacher);
    }

}
