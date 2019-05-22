package com.shop.controller;


import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wechat")
@Api(value = "Web-WeChatController",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WeChatController {

}
