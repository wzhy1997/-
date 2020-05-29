package com.wzhy.service;

import com.wzhy.mapper.CourseMapper;
import com.wzhy.pojo.Course;
import com.wzhy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
//    重做
public List<Course> getCourseByStudent(String id){
    id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    return courseMapper.getCourseByStudent(id);
}
    public List<Course> getCourseByTeacher(String id){
        id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.getCourseByTeacher(id);

    }
    //        查询课程信息和作业信息
    public Course queryCourseAndHomeworkTeacher(String id){
        Course courses = courseMapper.queryCourseAndHomeworkTeacher(id);
        return courses;
    }
    public Course queryCourseAndHomeworkStudent(String id){
        Course courses = courseMapper.queryCourseAndHomeworkStudent(id);
        return courses;
    }
//    查询课程信息
public Course queryCourse(String id){
    Course courses = courseMapper.queryCourse( id);
    return courses;
}
    //    老师创建课程
    public int createCourse(Course course){
        return courseMapper.createCourse(course);
    }
    //    加入课程
    public Course insertCourse(Course course){
        return courseMapper.insertCourse(course);
    }
    //    学生删除课程
    public int deleteCourseByStudent(@Param("id") String id, @Param("uid") String uid){
    uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.deleteCourseByStudent(id, uid);
    }
    //    老师删除课程
    public int deleteCourseByTeacher(@Param("id") String id, @Param("uid") String uid){
        uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.deleteCourseByTeacher(id,uid);
    }
    //    学生加入课程
    public int insertCourseByStudent(@Param("courseId") String courseId, @Param("uid") String uid){
        uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.insertCourseByStudent(courseId, uid);
    };
//老师加入课程
public int insertCourseByTeacher(@Param("courseId") String courseId, @Param("uid") String uid){
    return courseMapper.insertCourseByTeacher(courseId, uid);
}
    //    学生归档课程
    public int guidangCourseByStudent(@Param("id") String id, @Param("uid") String uid){
        uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.guidangCourseByStudent(id, uid);
    }
//    老师归档
public int guidangCourseByTeacher(@Param("id") String id, @Param("uid") String uid){
    uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    return courseMapper.guidangCourseByTeacher(id, uid);

}
    public  List<Course> guidangCourseByStudentQuery( String uid){
        uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.guidangCourseByStudentQuery( uid);
    }
    //    学生归档恢复
    public int guidangCourseByStudentRecover(@Param("id") String id, @Param("uid") String uid){
        uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return courseMapper.guidangCourseByStudentRecover(id, uid);
    }
//   老师归档回复
public int guidangCourseByTeacherRecover(@Param("id") String id, @Param("uid") String uid){
    uid = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    return courseMapper.guidangCourseByTeacherRecover(id, uid);
}
}
