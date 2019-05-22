package com.shop.common.configProperties.properties;


import com.shop.common.base.constant.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class ShopProperties {
    private SwaggerProperties swagger = new SwaggerProperties();
    private WeChatProperties weChat = new WeChatProperties();
    private QiniuProperties qiniuyun = new QiniuProperties();
}
