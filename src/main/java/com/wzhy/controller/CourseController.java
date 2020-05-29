package com.wzhy.controller;

import com.wzhy.pojo.Course;
import com.wzhy.pojo.RespBean;
import com.wzhy.pojo.User;
import com.wzhy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    //查询 学生主页
    @GetMapping("/getStudent")
    public RespBean getCourseByStudent(String id) {
        id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        String userRole = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserRole();
        if (userRole.equals("学生")) {
            List<Course> course = courseService.getCourseByStudent(id);
            if (course != null) {
                return RespBean.ok("学生课程卡片查询成功", course);
            } else {
                return RespBean.error("学生课程卡片查询失败");
            }
        } else if (userRole.equals("老师")) {
            List<Course> course = courseService.getCourseByTeacher(id);
            if (course != null) {
                return RespBean.ok("老师课程卡片查询成功", course);
            } else {
                return RespBean.error("老师课程卡片查询失败");
            }
        } else {
            return RespBean.error("登陆失败");
        }
    }

    //    查询课程和作业信息
    @GetMapping("/getCourse/{id}")
    public RespBean getCourse(@PathVariable("id") String id) {
        String role = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserRole();
        if(role.equals("老师")){
            Course courses = courseService.queryCourseAndHomeworkTeacher(id);
            if (courses != null) {
                return RespBean.ok("老师课程作业查询成功", courses);
            } else {
                return RespBean.error("老师课程作业查询失败");
            }
        }else {
            Course courses = courseService.queryCourseAndHomeworkStudent(id);
            if (courses != null) {
                return RespBean.ok("学生课程作业查询成功", courses);
            } else {
                return RespBean.error("学生课程作业查询失败");
            }
        }

    }
    @GetMapping("/getCourses/{id}")
    public RespBean getCourses(@PathVariable("id") String id) {
        Course courses = courseService.queryCourse(id);
        if (courses != null) {
            return RespBean.ok("课程查询成功", courses);
        } else {
            return RespBean.error("课程查询失败");
        }
    }
    //老师创建课程
        @PostMapping("/createCourse")
    public RespBean createCourse(@RequestBody Course course) {
        String i = (int) ((Math.random() * 9 + 1) * 100000) + "";
        course.setCourseId((i));
        course.setMemberCount(0);
        int course1 = courseService.createCourse(course);

        if (course1 != 0) {
            int i1 = courseService.insertCourseByTeacher(course.getCourseId(), ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
            if(i1!=0){
                System.out.println("插入课程");
            }
            return RespBean.ok("创建课程成功");

        } else {
            return RespBean.error("创建课程失败");
        }

    }

    //    学生删除课程
    @GetMapping("/deleteCourse/{id}")
    public RespBean deleteCourse(@PathVariable("id") String id, String uid) {
        uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
       String role = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserRole();
       if(role.equals("学生")){
           int course = courseService.deleteCourseByStudent(id, uid);
           if (course != 0) {
               return RespBean.ok("学生退课成功", course);
           } else {
               return RespBean.error("学生退课失败");
           }
       }else {
           int course = courseService.deleteCourseByTeacher(id, uid);
           if (course != 0) {
               return RespBean.ok("老师退课成功", course);
           } else {
               return RespBean.error("老师退课失败");
           }
       }

    }
//    插入课程
    @PostMapping("/insertCourse")
    public RespBean insertCourse(@RequestBody String courseId){
        String userRole = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserRole();
        if(userRole.equals("学生")){
            String[] split = courseId.split("=");
            System.out.println(split[0]);
            String  uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            int i = courseService.insertCourseByStudent(split[0], uid);
            if (i != 0) {
                return RespBean.ok("学生添加成功", i);

            } else {
                return RespBean.error("学生添加失败");
            }
        }else {
            String[] split = courseId.split("=");
            System.out.println(split[0]);
            String  uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            int i = courseService.insertCourseByTeacher(split[0], uid);
            if (i != 0) {
                return RespBean.ok("老师添加成功", i);

            } else {
                return RespBean.error("老师添加失败");
            }
        }

    }
//    学生归档
@GetMapping("/guidangByStudent/{id}")
    public RespBean guidangCourse(@PathVariable("id") String id){
        String  uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        String  role = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserRole();
        if(role.equals("学生")){
            int i = courseService.guidangCourseByStudent(id, uid);
            if (i != 0) {
                return RespBean.ok("学生归档成功", i);

            } else {
                return RespBean.error("学生归档失败");
            }
        }else {
            int i = courseService.guidangCourseByTeacher(id, uid);
            if (i != 0) {
                return RespBean.ok("老师归档成功", i);

            } else {
                return RespBean.error("老师归档失败");
            }
        }

    }
//    归档恢复
@GetMapping("/guidangRecover/{id}")
public RespBean guidangCourseRecover(@PathVariable("id") String id){
    String  uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    String  role = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserRole();
    if(role.equals("学生")){
        int i = courseService.guidangCourseByStudentRecover(id,uid);
        if (i != 0) {
            return RespBean.ok("学生归档恢复成功", i);
    
        } else {
            return RespBean.error("学生归档恢复失败");
        }
    }else {
        int i = courseService.guidangCourseByTeacherRecover(id, uid);
        if (i != 0) {
            return RespBean.ok("老师归档恢复成功", i);

        } else {
            return RespBean.error("老师归档恢复失败");
        }
    }

}
//学生归档查询guidangCourseByStudentQuery
@GetMapping("/guidangByStudentQuery")
public RespBean guidangCourseByStudentQuery(){
    String  uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    List<Course> i = courseService.guidangCourseByStudentQuery(uid);
    if (i != null) {
        return RespBean.ok("归档查询成功", i);

    } else {
        return RespBean.error("归档查询失败");
    }
}
}