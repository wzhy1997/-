package com.wzhy.service;

import com.wzhy.mapper.CouHomeworkMapper;
import com.wzhy.pojo.CouHomework;
import com.wzhy.pojo.StuHomework;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouHomeworkService {
    @Autowired
    CouHomeworkMapper couHomeworkMapper;
    public CouHomework getStuCourse(@Param("courseId")String courseId, @Param("homeworkId") String homeworkId){
        CouHomework stuCourse = couHomeworkMapper.getStuCourse(courseId,homeworkId);
        return stuCourse;
    }
    public CouHomework queryHomework(String id){
        return couHomeworkMapper.queryHomework(id);
    }
    public int postWork(StuHomework stuHomework){
        return couHomeworkMapper.postWork(stuHomework);
    }
}
