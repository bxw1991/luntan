package com.shop.dto;

import com.sun.scenario.effect.impl.prism.PrRenderInfo;
import lombok.Data;

@Data
public class UserDto {
    private String avatarUrl;
    private String city;
    private String country;
    private Integer gender;
    private String language;
    private String nickName;
    private String province;
    private String code;
}
