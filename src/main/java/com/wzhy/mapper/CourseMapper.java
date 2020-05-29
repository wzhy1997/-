package com.wzhy.mapper;

import com.wzhy.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

//    退档
    public void backShift(String id);
//    删除
    public void deleteCourse(String id);
// 卡片信息
public List<Course> getCourseByStudent(String id);
public List<Course> getCourseByTeacher(String id);

    public Course queryCourseAndHomeworkTeacher(String id);
    public Course queryCourseAndHomeworkStudent(String id);

    //    查询课程信息
    public Course queryCourse(String id);
//    老师创建课程
    public int createCourse(Course course);
//    加入课程
    public Course insertCourse(Course course);
//    学生删除课程
    public int deleteCourseByStudent(@Param("id") String id, @Param("uid") String uid);
    //    老师删除课程
    public int deleteCourseByTeacher(@Param("id") String id, @Param("uid") String uid);
//    学生加入课程
    public int insertCourseByStudent(@Param("courseId") String courseId, @Param("uid") String uid);
//    学生归档课程
    public int guidangCourseByStudent(@Param("id") String id, @Param("uid") String uid);
    //    老师归档课程
    public int guidangCourseByTeacher(@Param("id") String id, @Param("uid") String uid);
//   归档查询
public  List<Course> guidangCourseByStudentQuery(String uid);
//老师 加入课程
public int insertCourseByTeacher(@Param("courseId") String courseId, @Param("uid") String uid);

    //    学生归档恢复
public int guidangCourseByStudentRecover(@Param("id") String id, @Param("uid") String uid);
//老师归档恢复
public int guidangCourseByTeacherRecover(@Param("id") String id, @Param("uid") String uid);


}
