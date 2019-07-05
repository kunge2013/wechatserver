package com.kunfang.wechat;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class WeiChatAuthController {
    @RequestMapping(value = "/auth/{userName}/{passWord}", method = RequestMethod.GET)
    public Object auth(@PathVariable("userName") String userName, @PathVariable("passWord") String passWord) {
        Map<String, Object> map = new HashMap<>();
        map.put("success" , true);
        return map;
    }
}
