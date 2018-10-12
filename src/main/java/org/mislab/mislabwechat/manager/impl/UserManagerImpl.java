package org.mislab.mislabwechat.manager.impl;

import org.mislab.mislabwechat.dao.UserMapper;
import org.mislab.mislabwechat.entity.po.User;
import org.mislab.mislabwechat.manager.UserManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class UserManagerImpl implements UserManager{
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String openId) {
        User user = new User();
        User student = userMapper.findUserByOpenId(openId);
        user.setStudentId(student.getStudentId());
        user.setStudentName(student.getStudentName());
        return user;
    }

    @Override
    public List<User> getUserByMajor(String major) {
        List<User> list = userMapper.getUserByMajor(major);
        return list;
    }

}
