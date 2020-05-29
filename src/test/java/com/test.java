package com;

import com.wzhy.mapper.TeacherMapper;
import com.wzhy.pojo.Teacher;
import com.wzhy.pojo.User;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class test {
    @Autowired
    TeacherMapper teacherMapper;
    @Test
    public void test02(){
        String id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        System.out.println(id);
    }


}
