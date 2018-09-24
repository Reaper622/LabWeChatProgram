package org.mislab.mislabwechat.entity.po;

import lombok.Data;

/**
 * 作业类
 * 学生学号，成绩（评价），作业编号
 */
@Data
public class Grade {
    private String studentId;
    private String grade;
    private int taskId;
}
