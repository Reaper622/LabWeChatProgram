package org.mislab.mislabwechat.bizService;

import org.mislab.mislabwechat.entity.po.User;

import java.util.List;

public interface BizService {
    User getUserByOpenId(String openId);
    boolean bind(User user);
    List<User> getUserByMajor(String major);
    boolean unbind(String openId);
}
