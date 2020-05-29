package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String teacherId;
    private String teacherPassword;
    private String teacherName;
    private String teacherSchool;
    private String role;


}
