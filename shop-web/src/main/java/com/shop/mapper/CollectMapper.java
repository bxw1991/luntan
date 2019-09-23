package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.Article;
import com.shop.domain.Collect;
import com.shop.dto.CollectArticleDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CollectMapper extends MyMapper<Collect> {
    List<CollectArticleDto> articleListByOpenid(String openid);
}