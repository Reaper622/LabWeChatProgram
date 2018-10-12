package org.mislab.mislabwechat.bizService;

import org.mislab.mislabwechat.entity.po.SignInParam;
import org.mislab.mislabwechat.entity.po.Signer;
import org.mislab.mislabwechat.entity.po.User;
import org.mislab.mislabwechat.entity.vo.SignInStatus;
import org.mislab.mislabwechat.entity.vo.SignInfo;

import java.util.List;

public interface BizService {
    User getUserByOpenId(String openId);
    boolean bind(User user);
    List<User> getUserByMajor(String major);
    boolean unbind(String openId);
    SignInfo getSignNum();
    boolean saveSignNum(SignInfo signInfo);
    SignInStatus signInStatus(SignInParam signInParam);
    int findSignNumFromRedis(String signId);
    boolean addSignerToDB(Signer signer);
}
