package org.mislab.mislabwechat.entity.po;

import lombok.Data;

/**
 * 前端传过来签到的参数（输入的验证码，openId）
 */

@Data
public class SignInParam {
    private int signNum;
    private String openId;
    private String signId;
}
