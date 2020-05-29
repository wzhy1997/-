package com.wzhy.controller;

import com.wzhy.pojo.CouHomework;
import com.wzhy.pojo.RespBean;
import com.wzhy.pojo.StuHomework;
import com.wzhy.pojo.User;
import com.wzhy.service.CouHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CouHomeWorkController {
    @Autowired
    CouHomeworkService couHomeworkService;
        @GetMapping("/getCoursePersons/{courseId}/{homeworkId}")
    public RespBean getStuCourse(@PathVariable("courseId") String courseId,@PathVariable("homeworkId") String homeworkId){
        CouHomework couHomework = couHomeworkService.getStuCourse(courseId,homeworkId);
        if(couHomework!=null){
           return RespBean.ok("查询课程人数成功",couHomework);
        }else {
            return RespBean.error("查询课程人数失败");
        }}
//进入作业页面
    @GetMapping("/getHomework/{id}")
    public RespBean queryHomework(@PathVariable("id")String id){
        CouHomework homework = couHomeworkService.queryHomework(id);
        if(homework!=null){
            return RespBean.ok("查询作业成功",homework);
        }else {
            return RespBean.error("查询作业失败");
        }}
//        学生提交作业
    @PostMapping("/postHomework")
    public RespBean postHomework(StuHomework stuHomework,String message){
        String id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            stuHomework.setStudentId(id);
            String[] split = message.split("=");

            stuHomework.setHomeworkId("278410");
            Date date = new Date();

            stuHomework.setSubmitDate(date);
            stuHomework.setSubmitState("已提交");
            int i = couHomeworkService.postWork(stuHomework);
            if(i!=0){
            return RespBean.ok("提交作业成功");
        }else {
            return RespBean.error("提交作业失败");
    }
    }
}

