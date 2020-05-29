package com.wzhy.controller;

import com.wzhy.pojo.RespBean;
import com.wzhy.pojo.Teacher;
import com.wzhy.pojo.User;
import com.wzhy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("getTeacherById")
    public RespBean getTeacherById(String id){
        id =((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        Teacher teacher = teacherService.getTeacherById(id);
        if(teacher!=null){
            return RespBean.ok("获取老师用户信息", teacher);
        }else {
            return RespBean.error("无法查到用户");
        }
    }
}
