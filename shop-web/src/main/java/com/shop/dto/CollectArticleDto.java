package com.shop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CollectArticleDto {
    private Long id;
    private String subject;
    private Date createTime;
    private String nickName;
    private String avatarUrl;
}
