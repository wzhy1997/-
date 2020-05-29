package com.wzhy.mapper;

import com.wzhy.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {
//    查询老师信息
public Teacher getTeacherById(String id);
public int insertTeacher(Teacher teacher);

}
