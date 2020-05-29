package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentId;
    private String studentPassword;
    private String studentName;
    private String studentNumber;
    private String studentSchool;
    private String role;
    private StuHomework stuHomework;


}
