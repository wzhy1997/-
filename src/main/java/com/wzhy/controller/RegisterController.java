package com.wzhy.controller;

import com.wzhy.pojo.RespBean;
import com.wzhy.pojo.Teacher;
import com.wzhy.pojo.User;
import com.wzhy.service.StudentService;
import com.wzhy.service.TeacherService;
import com.wzhy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
@Autowired
UserService userService;
@Autowired
    StudentService studentService;
@Autowired
    TeacherService teacherService;


    @PostMapping("/rigesterTeacher")
    public RespBean insertUser(@RequestBody User user) {
//      老师注册
        user.setUserRole("老师");
        String password = user.getPassword();
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String encode = bc.encode(password);
        user.setPassword(encode);
        int user1 = userService.insertUser(user);
        if (user1!=0){
            Teacher teacher = new Teacher();
            teacher.setRole("老师");
            teacher.setTeacherId(user.getId());
            teacher.setTeacherName(user.getUsername());
            teacher.setTeacherPassword(encode);
            teacher.setTeacherSchool(user.getUserSchool());
            int teacher1 = teacherService.insertTeacher(teacher);
            if(teacher1!=0){
                return RespBean.ok("注册成功");
            }else {
                return RespBean.error("注册失败");
            }
        }else {
            return RespBean.error("用户注册失败");
        }

    }
    @PostMapping("/rigesterStudent")
    public RespBean insertStudent(@RequestBody User user) {
//      老师注册
        user.setUserRole("学生");
        String password = user.getPassword();
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String encode = bc.encode(password);
        user.setPassword(encode);
        int user1 = userService.insertUser(user);
        if (user1!=0){
            Teacher teacher = new Teacher();
            teacher.setRole("老师");
            teacher.setTeacherId(user.getId());
            teacher.setTeacherName(user.getUsername());
            teacher.setTeacherPassword(encode);
            teacher.setTeacherSchool(user.getUserSchool());
            int teacher1 = teacherService.insertTeacher(teacher);
            if(teacher1!=0){
                return RespBean.ok("注册成功");
            }else {
                return RespBean.error("注册失败");
            }
        }else {
            return RespBean.error("用户注册失败");
        }

    }
}
