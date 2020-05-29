package com.wzhy.service;

import com.wzhy.mapper.HomeworkMapper;
import com.wzhy.pojo.CouHomework;
import com.wzhy.pojo.Homework;
import com.wzhy.pojo.StuHomework;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;
    public int postHomework(Homework homework){
        return homeworkMapper.postHomework(homework);
    }
    public int postCouHomework(CouHomework couHomework){
        return homeworkMapper.postCouHomework(couHomework);
    }
//    发布作业再sthHomework
public int postStuHomework(StuHomework stuHomework){
        return homeworkMapper.postStuHomework(stuHomework);
}
//进入批阅
public StuHomework getStuHomework(String studentId)
{
    return homeworkMapper.getStuHomework(studentId);
}
//批阅
public int pigaizuoye(StuHomework stuHomework){
    return homeworkMapper.pigaizuoye(stuHomework);
}
    public List<Homework> getHomeworkList(String courseId){
        return homeworkMapper.getHomeworkList(courseId);
    }
    //    通过作业号查询相关信息
    public Homework getHomeworkById(String homeworkId){
        return homeworkMapper.getHomeworkById(homeworkId);
    }
    //    查询成绩
    public StuHomework getScore(@Param("studentId")String studentId, @Param("homeworkId") String HomeworkId){
        return homeworkMapper.getScore(studentId, HomeworkId);

    }
}
