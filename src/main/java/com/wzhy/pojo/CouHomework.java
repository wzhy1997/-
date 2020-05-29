package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouHomework {
    private String courseId;
    private String homeworkId;
    private String piyueCount;
    private Integer score;
    private String submitState;
    private List<Student> listStudent;
    private List<Teacher> listTeacher;
    private Homework homework;
    private StuHomework stuHomework;
  }
