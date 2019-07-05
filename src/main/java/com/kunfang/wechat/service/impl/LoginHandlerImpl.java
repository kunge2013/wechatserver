package com.kunfang.wechat.service.impl;

import com.kunfang.utils.OkHttpUtil;
import com.kunfang.wechat.service.ILoginHandler;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginHandlerImpl implements ILoginHandler {
    @Autowired
    OkHttpClient client;
    @Override
    public String loginWeChat(String appid, String appSecret, String code) {
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code" ,appid, appSecret, code);
        return OkHttpUtil.get(url, null, client);
    }
}
