package com.shop.controller;


import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import com.shop.service.WeChatService;
import com.shop.vo.WeChatInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Api(value = "Web-WeChatController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    public WeChatService weChatService;

    @PostMapping("/wxapp/login")
    @ApiOperation(value = "获取微信openId,session_key", httpMethod = "POST")
    public Wrapper<WeChatInfo> getWechatToken(@RequestParam String code) {

        WeChatInfo weChatInfo = weChatService.getWeChatInfo(code);
        return WrapMapper.ok(weChatInfo);
    }


    @GetMapping("/check-token")
    @ApiOperation(value = "检查token是否失效",httpMethod = "GET")
    public Wrapper checkToken(@RequestParam String token){
        boolean b = weChatService.checkToken(token);
        if (b){
            return WrapMapper.ok();
        }
        return WrapMapper.wrap(600,"session_key过期");
    }


}
