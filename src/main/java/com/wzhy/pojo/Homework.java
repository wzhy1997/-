package com.wzhy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Homework {
    private String homeworkId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date publishDate;
    private String homeworkName;
    private String homeworkIntroduction;
    @JsonFormat( pattern="yyyy-MM-dd")
    private Date deadline;
    private String maxScore;
    private String operateModel;
    private String courseId;
}
