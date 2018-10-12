package org.mislab.mislabwechat.entity.vo;

import lombok.Data;

/**
 * 返回给前端的对象（openId,签到是否成功）
 */
@Data
public class SignInStatus {
    private String openId;
    private boolean flag;
}
