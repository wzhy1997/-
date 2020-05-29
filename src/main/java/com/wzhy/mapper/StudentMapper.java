package com.wzhy.mapper;

import com.wzhy.pojo.Student;
import com.wzhy.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {
//    用户表与学生的对应
    public Student getStudent(String id);
//    查询归档
    public List<Student> getGuiDang(String id);
//    通过id查询学生的所有信息
    public Student getStudentById(String id);
//    插入学生
public Student insertStudent(Student student);
//      学

}
