package com.shop.service;

import com.github.pagehelper.PageInfo;
import com.shop.domain.Article;
import com.shop.domain.Collect;
import com.shop.dto.ArticleDto;
import com.shop.dto.CollectArticleDto;

public interface CollectService {
    int getByOpenId(Collect collect);
    int saveCollect(Collect collect);
    int delete(Collect collect);
    PageInfo<CollectArticleDto> articleListByOpenid(String openid, Integer pageNum, Integer pageSize);
}
