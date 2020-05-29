package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuCourse {
    private String studentId;
    private String courseId;
    private String score;
    private Integer isDelete;
}
