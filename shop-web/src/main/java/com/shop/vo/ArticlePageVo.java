package com.shop.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ArticlePageVo implements Serializable {
    private static final long serialVersionUID = -1604377641694493389L;
    private String id;
    private String avatarUrl;
    private String nickName;
    private String subject;
    private String place;
    private Date createTime;
    private Date updateTime;
    private Integer looks;
    private Long distance;
}
