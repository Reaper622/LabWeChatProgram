package org.mislab.mislabwechat.manager;

import org.mislab.mislabwechat.entity.po.User;

public interface UserManager {
    User getUserInfo(String openId);
}
