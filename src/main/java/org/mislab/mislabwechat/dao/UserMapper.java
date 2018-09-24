package org.mislab.mislabwechat.dao;

import org.mislab.mislabwechat.entity.po.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {
    boolean insertUser(User user);
    User findUserByOpenId(String openId);
}
