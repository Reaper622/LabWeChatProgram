package org.mislab.mislabwechat.dao;

import org.mislab.mislabwechat.entity.po.User;

import java.util.List;

public interface UserMapper {
    boolean insertUser(User user);
    User findUserByOpenId(String openId);
    List<User> getUserByMajor(String major);
    boolean deleteUser(String openId);
}
