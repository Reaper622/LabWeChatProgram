package org.mislab.mislabwechat.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mislab.mislabwechat.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserDaoTest {
    @Autowired
    private UserMapper userMapper;
    private User user;

    @Before
    public void before(){
        user = new User();
        user.setStudentName("sba");
        user.setStudentId("7890");
        user.setOpenId("sbb345");
        user.setMajor("houTai");
    }

    @Test
    public void findUserByOpenIdTest(){
        User user = userMapper.findUserByOpenId("sb123");
        assertEquals("www.sb.com", user.getAvatarUrl());
    }

    @Test
    public void getUserByMajor(){
        List<User> list = userMapper.getUserByMajor("qianDuan");
        assertEquals(2,list.size());
    }

    @Test
    public void unBind(){
        boolean flag = userMapper.deleteUser("sb123");
        assertEquals(true, flag);
    }

//    @Test
//    public void insertUserTest(){
//        boolean flag = userMapper.insertUser(user);
//        assertEquals(true, flag);
//    }

}
