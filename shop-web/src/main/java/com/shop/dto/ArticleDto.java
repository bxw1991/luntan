package com.shop.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ArticleDto {
    private String openid;
    private String subject;
    private String place;
    private String contact;
    private String content;
    private Integer type;
    private List<String> imageUrls;
    private BigDecimal longitude;
    private BigDecimal latitude;
}
