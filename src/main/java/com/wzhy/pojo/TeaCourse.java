package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeaCourse {
    private String teacherId;
    private String courseId;
    private String courseState;
    private Integer isdelete;
}
