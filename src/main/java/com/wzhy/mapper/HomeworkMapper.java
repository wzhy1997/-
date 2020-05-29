package com.wzhy.mapper;

import com.wzhy.pojo.CouHomework;
import com.wzhy.pojo.Homework;
import com.wzhy.pojo.StuHomework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HomeworkMapper {
    //发布作业再homework
    public int postHomework(Homework homework);

    //发作业再couhomework
    public int postCouHomework(CouHomework couHomework);

    //发布作业再stuhomework
    public int postStuHomework(StuHomework stuHomework);

    //    进入批阅
    public StuHomework getStuHomework(@Param("studentId") String studentId);

    //    批改作业
    public int pigaizuoye(StuHomework stuHomework);

    //    查询课程作业
    public List<Homework> getHomeworkList(String courseId);
//    通过作业号查询相关信息
    public Homework getHomeworkById(String homeworkId);
//    查询成绩
    public StuHomework getScore(@Param("studentId")String studentId,@Param("homeworkId") String HomeworkId);
}


