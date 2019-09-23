package com.shop.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleDetailDto {
    private String id;
    private String openid;
    private String avatarUrl;
    private String nickName;
    private String subject;
    private String place;
    private String contact;
    private String content;
    private Date updateTime;
    private Integer looks;
    private String imageUrls;
    private Integer commentTimes;
    private String[] imageUrlsArray;
    private Date createTime;
}
