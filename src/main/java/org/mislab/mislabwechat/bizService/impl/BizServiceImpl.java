package org.mislab.mislabwechat.bizService.impl;

import org.mislab.mislabwechat.bizService.BizService;
import org.mislab.mislabwechat.dao.SignerMapper;
import org.mislab.mislabwechat.dao.UserMapper;
import org.mislab.mislabwechat.entity.po.EntityCache;
import org.mislab.mislabwechat.entity.po.SignInParam;
import org.mislab.mislabwechat.entity.po.Signer;
import org.mislab.mislabwechat.entity.po.User;
import org.mislab.mislabwechat.entity.vo.SignInStatus;
import org.mislab.mislabwechat.entity.vo.SignInfo;
import org.mislab.mislabwechat.manager.impl.ICacheManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class BizServiceImpl implements BizService{

    @Autowired
    UserMapper userMapper;
    @Autowired
    SignerMapper signerMapper;

    @Resource
    ICacheManagerImpl iCacheManager;

    public User getUserByOpenId(String openId) {
        User user = userMapper.findUserByOpenId(openId);
        return user;
    }

    public boolean bind(User user) {
        if(!userMapper.insertUser(user)|| user == null) {
            return false;
        }
        else return true;
    }

    @Override
    public List<User> getUserByMajor(String major) {
        List<User> list = userMapper.getUserByMajor(major);
        return list;
    }

    @Override
    public boolean unbind(String openId) {
        if(!userMapper.deleteUser(openId) || openId == null){
            return false;
        }
        else return true;
    }

    /**
     * 前端第一次请求获取验证码
     * @return signInfo(签到编号,签到码)
     */
    @Override
    public SignInfo getSignNum() {
        int signNum;
        String signId;
        Random random = new Random();
        signNum = random.nextInt(9000-1000+1) + 1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        signId = simpleDateFormat.format(new Date());
        SignInfo signInfo = new SignInfo();
        signInfo.setSignId(signId);
        signInfo.setSignNum(signNum);
        return signInfo;
    }

    /**
     * 将signInfo(签到编号,签到码)存入缓存
     * @param signInfo
     * @return boolean
     */
    @Override
    public boolean saveSignNum(SignInfo signInfo) {
        String signId = signInfo.getSignId();
        int signNum = signInfo.getSignNum();
        iCacheManager.putCache(signId, signNum,5*60*1000L);
        return true;
    }

    /**
     * 前端传signInParam(签到编号,openId,用户输入的签到码)
     * 后台进行校验
     * @param signInParam
     * @return
     */
    @Override
    public SignInStatus signInStatus(SignInParam signInParam) {
        boolean flag;
        int signNum = signInParam.getSignNum();
        String openId = signInParam.getOpenId();
        String signId = signInParam.getSignId();
        int signNumFromRedis = findSignNumFromRedis(signId);
        Signer signer = new Signer();
        signer.setSignId(signId);
        User user = getUserByOpenId(openId);
        signer.setStudentId(user.getStudentId());
        signer.setStudentName(user.getStudentName());
        if(signNum == signNumFromRedis){
            addSignerToDB(signer);
            flag = true;
        }else
            flag = false;
        SignInStatus signInStatus = new SignInStatus();
        signInStatus.setOpenId(openId);
        signInStatus.setFlag(flag);
        return signInStatus;
    }

    /**
     * 从缓存中通过key(签到编号signId)取出value(签到码signNum）
     * @return
     */
    @Override
    public int findSignNumFromRedis(String signId) {
        EntityCache signNumber = iCacheManager.getCacheByKey(signId);
        int signNum = Integer.parseInt(signNumber.toString());
        return signNum;
    }

    @Override
    @Async
    public boolean addSignerToDB(Signer signer) {
        if(!signerMapper.insertSigner(signer) || signer == null){
            return false;
        }
        return true;
    }

}
