package com.jianpan.sell.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {


    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法");
        log.info("code=" + code);

        String newUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=wx4e7096883b4d0464&secret=ff4067fbb9f20e16b5edbf5bb253ed0c&" +
                "code=" + code + "&" +
                "grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(newUrl, String.class);
        log.info("response{}" + response);

    }
}
