package com.kunfang.wechat;

import com.google.gson.Gson;
import com.kunfang.wechat.service.ILoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class WeiChatAuthController {
    @Autowired
    private ILoginHandler handler;
    @RequestMapping(value = "/auth/{userName}/{passWord}/{code}", method = RequestMethod.GET)
    public Object auth(@PathVariable("userName") String userName, @PathVariable("passWord") String passWord, @PathVariable("code") String code) {
        Map<String, Object> map = new HashMap<>();
        String appId = "wx8288e06d6753207c";
        String appSecret = "6f3e3db163f0627b9853d53c7fe88f3c";
        String response =  handler.loginWeChat(appId, appSecret, code);
        AuthInfo authInfo = new Gson().fromJson(response, AuthInfo.class);
        map.put("success" , true);
        if (null != authInfo.getErrcode()) {
            map.put("success" , false);
        }
        map.put("openId", authInfo);
        return map;
    }
}
