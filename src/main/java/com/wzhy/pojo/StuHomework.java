package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuHomework {
    private String studentId;
    private String homeworkId;
    private Date submitDate;
    private String message;
    private String submitState;
    private String submitCount;
    private String scores;
}
