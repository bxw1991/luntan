package com.shop.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BrifArticleDto implements Serializable {
    private static final long serialVersionUID = -2223124545201214760L;
    private Long id;
    private String subject;
    private Date createTime;
    private String nickName;
    private String avatarUrl;
}
