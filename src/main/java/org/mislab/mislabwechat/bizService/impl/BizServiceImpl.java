package org.mislab.mislabwechat.bizService.impl;

import org.mislab.mislabwechat.bizService.BizService;
import org.mislab.mislabwechat.dao.UserMapper;
import org.mislab.mislabwechat.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BizServiceImpl implements BizService{

    @Autowired
    UserMapper userMapper;

    /**
     * 通过openId去拿user
     * @return user
     */
    public User getUserByOpenId(String openId) {
        User user = userMapper.findUserByOpenId(openId);
        return user;
    }

    /**
     * 绑定用户
     * @param user
     * @return
     */
    public boolean bind(User user) {
        if(!userMapper.insertUser(user)|| user == null) {
            return false;
        }
        else return true;
    }
}
