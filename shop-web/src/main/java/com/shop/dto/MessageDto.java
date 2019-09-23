package com.shop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDto {
    private Long articleId;
    private Long commentId;
    private String avatarUrl;
    private Date createTime;
    private String nickName;
    private String comment;
    private String openid;
    private String replyId;
    private Integer haveRead;
}
