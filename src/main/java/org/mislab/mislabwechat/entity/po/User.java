package org.mislab.mislabwechat.entity.po;

import lombok.Data;

/**
 * 用户类
 * openId,学号,姓名,权限(0为无，1为有)
 */
@Data
public class User {
    private String openId;
    private String studentId;
    private String studentName;
}
