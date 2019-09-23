package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.Article;
import com.shop.dto.ArticleDetailDto;
import com.shop.dto.BrifArticleDto;
import com.shop.vo.ArticlePageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Component
public interface ArticleMapper extends MyMapper<Article> {
    List<ArticlePageVo> queryPickListByUpdateTimeDesc();
    List<ArticlePageVo> queryLoseListByUpdateTimeDesc();
    List<ArticlePageVo> search(@Param("type") Integer type, @Param("searchInfo") String searchInfo);
    List<ArticlePageVo> nearSearch(@Param("searchInfo") String searchInfo,@Param("latitude") BigDecimal latitude, @Param("longitude") BigDecimal longitude);
    int deleteAll(Integer type);
    ArticleDetailDto getArticleDetailById(Long id);
    List<ArticlePageVo> getNearArticles(@Param("latitude") BigDecimal latitude, @Param("longitude") BigDecimal longitude);
    List<BrifArticleDto> selectBrifList(@Param("type") Integer type,@Param("openid") String openid);
 }