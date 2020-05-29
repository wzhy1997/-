package com.wzhy.service;

import com.wzhy.mapper.StudentMapper;
import com.wzhy.pojo.Student;
import com.wzhy.pojo.Teacher;
import com.wzhy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    public Student getStudent(){
        String id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return studentMapper.getStudent(id);
    }
    public List<Student> getGuiDang(){
        String id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return studentMapper.getGuiDang(id);
    }
//    通过学生id获取学生信息
public Student getStudentById(){
        String id = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    return studentMapper.getStudentById(id);
}
    public Student insertStudent(Student student){
      return studentMapper.insertStudent(student);
    }

}
