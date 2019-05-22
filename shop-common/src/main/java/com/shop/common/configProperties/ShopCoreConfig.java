package com.shop.common.configProperties;

import com.shop.common.configProperties.properties.ShopProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(ShopProperties.class)
public class ShopCoreConfig {

}
