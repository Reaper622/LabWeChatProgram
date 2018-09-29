package org.mislab.mislabwechat.service;

import com.alibaba.fastjson.JSONObject;
import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.po.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    ResponseEntity<User> getUserInfo(@PathVariable String openId);
    ResponseEntity<User> bindUser(JSONObject json);
    ResponseEntity<List<User>> getUserByMajor(@PathVariable String major);
    ResponseEntity<User> unbind(@PathVariable String openId);
}
