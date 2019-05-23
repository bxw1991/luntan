package com.shop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.common.base.exception.BusinessException;
import com.shop.common.configProperties.properties.ShopProperties;
import com.shop.service.WeChatService;
import com.shop.vo.WeChatInfo;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;


@Service
public class WeChatInfoSeviceImpl implements WeChatService {

    @Autowired
    private ShopProperties shopProperties;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    String url = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Override
    public WeChatInfo getWeChatInfo(String code) {
        String accessTokenUrl = String.format(url, shopProperties.getWeChat().getAppId(),
                shopProperties.getWeChat().getAppSecret(),
                code);

        //请求openid，session_key
        String response = restTemplate.getForObject(accessTokenUrl, String.class);
        Map<String, Object> result = null;
        try {
            result = objectMapper.readValue(response, Map.class);
        } catch (Exception e) {
            throw new BusinessException("微信登录返回异常");
        }

        String openid = MapUtils.getString(result, "openid");
        String session_key = MapUtils.getString(result, "session_key");

        //存入redis 默认失效时间7200S
        redisTemplate.opsForValue().set(session_key,"shop_wechat_" + openid,7200, TimeUnit.SECONDS);

        WeChatInfo weChatInfo = new WeChatInfo(openid, session_key);

        return weChatInfo;
    }

    @Override
    public boolean checkToken(String token) {
        String result = (String) redisTemplate.opsForValue().get(token);
        if (result == null){
            return false;
        }
        return true;
    }

}
