package org.mislab.mislabwechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.mislab.mislabwechat.bizService.impl.BizServiceImpl;
import org.mislab.mislabwechat.constant.ReturnCode;
import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.mislab.mislabwechat.constant.ExceptionMessages.SUCCESS;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserServiceImpl {

    @Autowired
    BizServiceImpl bizServiceImpl;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public ResponseEntity<User> getUserInfo(@RequestParam("openId") String openId) {
        User user = bizServiceImpl.getUserByOpenId(openId);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,user);
    }

    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    public ResponseEntity<User> bindUser(@RequestBody JSONObject json) {
        User user = json.toJavaObject(User.class);
        bizServiceImpl.bind(user);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,null);
    }
}
