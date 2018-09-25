package org.mislab.mislabwechat.service;

import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.po.User;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
    ResponseEntity<User> getUserInfo(@PathVariable String openId);
    ResponseEntity<User> bindUser(User user);
}
