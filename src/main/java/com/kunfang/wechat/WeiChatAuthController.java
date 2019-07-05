package com.kunfang.wechat;

import com.alibaba.druid.util.HttpClientUtils;
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
        String appId = "";
        String appSecret = "";
        String openId =  handler.loginWeChat(appId, appSecret, code);
        map.put("success" , true);
        map.put("openId" , openId);
        return map;
    }
}
