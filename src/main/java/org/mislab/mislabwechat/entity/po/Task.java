package org.mislab.mislabwechat.entity.po;

import lombok.Data;

/**
 * 作业类
 * 学生学号，作业编号
 */
@Data
public class Task {
    private String studentId;
    private int taskId;
}
