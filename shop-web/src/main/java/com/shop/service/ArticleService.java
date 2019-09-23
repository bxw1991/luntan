package com.shop.service;

import com.github.pagehelper.PageInfo;
import com.shop.common.base.dto.BaseQuery;
import com.shop.dto.ArticleDetailDto;
import com.shop.dto.ArticleDto;
import com.shop.dto.BrifArticleDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ArticleService  {
    String uploadImage(MultipartFile multipartFile) throws IOException;
    int insert(ArticleDto articleDto);
    PageInfo queryPickListWithPage(BaseQuery baseQuery);
    PageInfo search(Integer type,String searchInfo,Integer pageNum,Integer pageSize);
    PageInfo nearSearch(String searchInfo,Integer pageNum,Integer pageSize,BigDecimal latitude, BigDecimal longitude);
    PageInfo<BrifArticleDto> brifList(Integer type,String openid,Integer pageNum,Integer pageSize);
    int deleteById(Long id);
    int deleteAll(Integer type);
    PageInfo queryLoseListWithPage(BaseQuery baseQuery);
    ArticleDetailDto getArticleDetailById(Long id);
    Integer getTypeByArticleId(Long id);
    PageInfo getNearArticles(BigDecimal latitude,BigDecimal longitude,Integer pageNum,Integer pageSize);
}
