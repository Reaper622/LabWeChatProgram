package org.mislab.mislabwechat.entity.po;

import lombok.Data;

/**
 * 把签到情况存到数据库中（签到的编号，学生学号，姓名）
 */
@Data
public class Signer {
    private String signId;
    private String studentName;
    private String studentId;
}
