package com.wzhy.mapper;

import com.wzhy.pojo.CouHomework;
import com.wzhy.pojo.Homework;
import com.wzhy.pojo.StuHomework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CouHomeworkMapper {
    public CouHomework getStuCourse(@Param("courseId")String courseId, @Param("homeworkId") String homeworkId);
//    老师发布作业
    public Homework postHomework();
//    进入学生页面 显示 学生交作业的情况 和作业的信息
    public CouHomework queryHomework(String id);
//    学生提交作业
    public int postWork(StuHomework stuHomework);
//    点击修改进入学生修改作业页面并显示其作业
//    查询当前课程的学生人数


}
