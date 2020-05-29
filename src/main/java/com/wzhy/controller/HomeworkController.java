package com.wzhy.controller;

import com.wzhy.pojo.*;
import com.wzhy.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class HomeworkController {
@Autowired
    HomeworkService homeworkService;
@PostMapping("/publishHomework")
    public RespBean postHomework(@RequestBody Homework homework) throws IOException {
    String courseId = homework.getCourseId();
    String i = (int) ((Math.random() * 9 + 1) * 100000) + "";
    homework.setHomeworkId(i);
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date deadline = homework.getDeadline();
    homework.setPublishDate(new Date());
    homework.setOperateModel(null);
    CouHomework couHomework = new CouHomework();
    couHomework.setHomeworkId(homework.getHomeworkId());
    couHomework.setCourseId(courseId);
    homeworkService.postCouHomework(couHomework);
    int i1 = homeworkService.postHomework(homework);

//    StuHomework stuHomework = new StuHomework();
//    stuHomework.setHomeworkId(homework.getHomeworkId());
//    String studentId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
//    stuHomework.setStudentId(studentId);
//    homeworkService.postHomework(homework);
//    int i1 = homeworkService.postStuHomework(stuHomework);
    if (i1 != 0) {
        return RespBean.ok("增加作业成功");
    } else {
    return     RespBean.error("增加作业失败");
    }

}
//进入批阅界面
    @GetMapping("/gopiyue/{studentId}")
    public RespBean gopiyue(@PathVariable("studentId") String studentId){
        StuHomework stuHomework = homeworkService.getStuHomework(studentId);

        if (stuHomework!=null){
           return RespBean.ok("查询成功", stuHomework);
        }else {
        return     RespBean.error("查询失败");
        }

    }
//    批改作业
    @PostMapping("/pigai")
    public RespBean pigai(@RequestBody StuHomework stuHomework){

        int i = homeworkService.pigaizuoye(stuHomework);

        if(i!=0){
          return   RespBean.ok("批改成功");
        }else {
        return     RespBean.error("批改失败");
        }
    }
//    获取作业信息
    @GetMapping("/getHomeworkList/{courseId}")
    public RespBean getHomework(@PathVariable("courseId") String courseId){
        List<Homework> homeworkList = homeworkService.getHomeworkList(courseId);
        if (homeworkList!=null){
            return RespBean.ok("查询课程成功", homeworkList);
        }else {
            return RespBean.error("查询课程失败");
        }
    }
    @GetMapping("/getHomewokById/{homeworkId}")
    public RespBean getHomeworkById(@PathVariable("homeworkId") String homeworkId){
        Homework homeworkById = homeworkService.getHomeworkById(homeworkId);
        if(homeworkById!=null){
            return RespBean.ok("查询作业成功",homeworkById);
        }else {
            return RespBean.error("查询作业失败");
        }

    }
//    查询成绩
    @GetMapping("/getScore/{homeworkId}")
    public RespBean getSoucre(@PathVariable("homeworkId")String homeworkId){
        String id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        StuHomework score = homeworkService.getScore(id, homeworkId);
        if(score!=null){
            return RespBean.ok("查询成绩成功", score);
        }else {
            return RespBean.error("查询成绩失败");
        }
    }
}
