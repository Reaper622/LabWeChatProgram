package org.mislab.mislabwechat.service;

import org.mislab.mislabwechat.bizService.BizService;
import org.mislab.mislabwechat.constant.ReturnCode;
import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.mislab.mislabwechat.constant.ExceptionMessages.SUCCESS;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserService {

    @Autowired
    BizService bizService;

    @GetMapping("openId")
    public ResponseEntity<User> getUserInfo(@PathVariable String openId) {
        User user = bizService.getUserByOpenId(openId);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,user);
    }

    @PostMapping
    public ResponseEntity<User> bindUser(User user) {
        bizService.bind(user);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,user);
    }
}
