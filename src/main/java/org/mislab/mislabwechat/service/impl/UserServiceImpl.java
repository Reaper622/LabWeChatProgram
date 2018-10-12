package org.mislab.mislabwechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.mislab.mislabwechat.bizService.impl.BizServiceImpl;
import org.mislab.mislabwechat.constant.ReturnCode;
import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.po.SignInParam;
import org.mislab.mislabwechat.entity.po.User;
import org.mislab.mislabwechat.entity.vo.SignInStatus;
import org.mislab.mislabwechat.entity.vo.SignInfo;
import org.mislab.mislabwechat.manager.impl.ICacheManagerImpl;
import org.mislab.mislabwechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.mislab.mislabwechat.constant.ExceptionMessages.SUCCESS;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserServiceImpl implements UserService {

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

    @Override
    @RequestMapping(value = "/getUserByMajor", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByMajor(@RequestParam("major") String major) {
        List<User> list = bizServiceImpl.getUserByMajor(major);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,list);
    }

    @Override
    @RequestMapping(value = "/unbind/{openId}", method = RequestMethod.DELETE)
    public ResponseEntity<User> unbind(@PathVariable("openId") String openId) {
        bizServiceImpl.unbind(openId);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,null);
    }

    @Override
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ResponseEntity<SignInStatus> signIn(@RequestBody JSONObject jsonObject) {
        SignInParam signInParam = jsonObject.toJavaObject(SignInParam.class);
        SignInStatus signInStatus = bizServiceImpl.signInStatus(signInParam);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS, signInStatus);
    }

    @Override
    @RequestMapping(value = "/getSignNum", method = RequestMethod.GET)
    public ResponseEntity<SignInfo> getSignNum() {
        SignInfo signInfo = bizServiceImpl.getSignNum();
        bizServiceImpl.saveSignNum(signInfo);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS,signInfo);
    }


}
