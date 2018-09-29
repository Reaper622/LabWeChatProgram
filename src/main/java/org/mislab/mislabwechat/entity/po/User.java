package org.mislab.mislabwechat.entity.po;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String openId;
    private String studentId;
    private String studentName;
    private Date createTime;
    private Date updateTime;
    private String major;
    private String avatarUrl;
}
