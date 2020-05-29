package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
private String courseId;
private String courseName;
private String courseClass;
private String courseYear;
private String courseTerm;
private Integer memberCount;
private Integer operateModel;
private List<Homework> listHomework;
private Teacher teacher;
private List<Student> listStudent;
}
