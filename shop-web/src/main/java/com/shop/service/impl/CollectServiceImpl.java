package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.domain.Article;
import com.shop.domain.Collect;
import com.shop.dto.CollectArticleDto;
import com.shop.mapper.CollectMapper;
import com.shop.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public int getByOpenId(Collect collect) {

        return collectMapper.selectCount(collect);
    }

    @Override
    public int saveCollect(Collect collect) {
        return  collectMapper.insert(collect);
    }

    @Override
    public int delete(Collect collect) {
        return  collectMapper.delete(collect);
    }

    @Override
    public PageInfo<CollectArticleDto> articleListByOpenid(String openid,Integer pageNum,Integer pageSize) {
        List<CollectArticleDto> articles = collectMapper.articleListByOpenid(openid);
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<CollectArticleDto>(articles);

    }
}
