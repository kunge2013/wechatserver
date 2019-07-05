package com.kunfang.wechat.service;

public interface ILoginHandler {
     String loginWeChat(String appid, String appSecret, String code);
}
