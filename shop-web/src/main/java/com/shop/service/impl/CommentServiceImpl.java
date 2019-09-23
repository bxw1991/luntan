package com.shop.service.impl;

import com.google.common.collect.Lists;
import com.shop.domain.Article;
import com.shop.domain.Comment;
import com.shop.domain.Reply;
import com.shop.dto.CommentReplyDto;
import com.shop.enums.ExceptionEnum;
import com.shop.exception.BusException;
import com.shop.mapper.ArticleMapper;
import com.shop.mapper.CommentMapper;
import com.shop.mapper.ReplyMapper;
import com.shop.service.ArticleService;
import com.shop.service.CommentService;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int save(Comment comment) {
        Long articleId = comment.getArticleId();
        Article article = articleMapper.selectByPrimaryKey(articleId);
        if (article == null){
            throw new BusException(ExceptionEnum.MG00011.getCode(),ExceptionEnum.MG00011.getMessage());
        }
        article.setUpdateTime(new Date());
        articleMapper.updateByPrimaryKey(article);
        comment.setHaveRead(0);
        comment.setHaveReply(0);
        int insert = commentMapper.insert(comment);
        return insert;
    }

    @Override
    public List<CommentReplyDto> getcommentReplyDtoList(Long articleId) {
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        List<Comment> commentList = commentMapper.select(comment);
        List<CommentReplyDto> list = Lists.newArrayList();
        if (commentList != null){
            for (Comment comment1 : commentList){
                CommentReplyDto commentReplyDto = new CommentReplyDto();
                BeanUtils.copyProperties(comment1,commentReplyDto);
                Reply reply = new Reply();
                reply.setCommentId(comment1.getId());
                List<Reply> replies = replyMapper.select(reply);
                commentReplyDto.setReplyList(replies);
                list.add(commentReplyDto);
            }
        }
        return list;
    }

    @Override
    public int deleteById(Long id) {
        int i = commentMapper.deleteByPrimaryKey(id);
        Reply reply = new Reply();
        reply.setCommentId(id);
        replyMapper.delete(reply);

        return i;
    }
}
