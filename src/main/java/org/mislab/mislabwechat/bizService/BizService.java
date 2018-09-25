package org.mislab.mislabwechat.bizService;

import org.mislab.mislabwechat.entity.po.User;

public interface BizService {
    User getUserByOpenId(String openId);
    boolean bind(User user);
}
