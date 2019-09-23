package com.shop.service.impl;

import com.shop.domain.Article;
import com.shop.domain.Reply;
import com.shop.mapper.ArticleMapper;
import com.shop.mapper.ReplyMapper;
import com.shop.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int save(Reply reply) {
//        reply.setLove(0l);
//        reply.setRead(0);
        Long articleId = reply.getArticleId();
        Article article = new Article();
        article.setId(articleId);
        article.setUpdateTime(new Date());
        articleMapper.updateByPrimaryKeySelective(article);
        return replyMapper.insertSelective(reply);
    }

    @Override
    public int deleteById(Long id) {
        return replyMapper.deleteByPrimaryKey(id);
    }
}
