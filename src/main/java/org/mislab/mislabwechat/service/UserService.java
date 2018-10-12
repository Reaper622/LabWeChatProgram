package org.mislab.mislabwechat.service;

import com.alibaba.fastjson.JSONObject;
import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.po.User;
import org.mislab.mislabwechat.entity.vo.SignInStatus;
import org.mislab.mislabwechat.entity.vo.SignInfo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    ResponseEntity<User> getUserInfo(@PathVariable String openId);
    ResponseEntity<User> bindUser(JSONObject json);
    ResponseEntity<List<User>> getUserByMajor(@PathVariable String major);
    ResponseEntity<User> unbind(@PathVariable String openId);
    ResponseEntity<SignInStatus> signIn(JSONObject jsonObject);
    ResponseEntity<SignInfo> getSignNum();
}
