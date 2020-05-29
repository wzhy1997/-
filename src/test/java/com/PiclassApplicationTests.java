package com;

import com.wzhy.service.CourseService;
import com.wzhy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PiclassApplicationTests {
@Autowired
    UserService userService;
@Autowired
    CourseService courseService;
    @Test
    void contextLoads() {
BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String encode = bc.encode("123");
        System.out.println(encode);
    }
    @Test
    void test1(){

    }
}
