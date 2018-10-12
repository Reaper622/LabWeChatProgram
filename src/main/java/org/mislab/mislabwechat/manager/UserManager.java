package org.mislab.mislabwechat.manager;

import org.mislab.mislabwechat.entity.po.User;

import java.util.List;

public interface UserManager {
    User getUserInfo(String openId);
    List<User> getUserByMajor(String major);

}
