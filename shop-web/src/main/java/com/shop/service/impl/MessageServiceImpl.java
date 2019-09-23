package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.utils.PublicUtil;
import com.shop.domain.Comment;
import com.shop.domain.Reply;
import com.shop.dto.CommentReadDto;
import com.shop.dto.MessageDto;
import com.shop.dto.ReplyReadDto;
import com.shop.mapper.CommentMapper;
import com.shop.mapper.MessageMapper;
import com.shop.mapper.ReplyMapper;
import com.shop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private  MessageMapper messageMapper;

    @Override
    public PageInfo<MessageDto> notReadByOpenId(String openid,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MessageDto> messageDtoNotReply = replyMapper.notReadByOpenId(openid);
        return new PageInfo<>(messageDtoNotReply);
    }

    @Override
    public int haveRead(String openid) {
        commentMapper.haveRead(openid);
        replyMapper.haveRead(openid);
        return 1;
    }

    @Override
    public int countByOpenid(String openid) {
        Reply reply = new Reply();
        reply.setToOpenid(openid);
        reply.setHaveRead(0);
        int i = replyMapper.selectCount(reply);
        Comment comment = new Comment();
        comment.setHaveRead(0);
        comment.setToOpenid(openid);
        int i1 = commentMapper.selectCount(comment);
        return i + i1;
    }

    @Override
    public int commentRead(CommentReadDto commentReadDto) {
        List<Long> commentIdList = commentReadDto.getCommentIdList();
        if (PublicUtil.isEmpty(commentIdList)){
            return 1;
        }
        int i = commentMapper.batchRead(commentIdList);
        return i;
    }

    @Override
    public int replyRead(ReplyReadDto replyReadDto) {
        List<Long> replyIdList = replyReadDto.getReplyIdList();
        if (PublicUtil.isEmpty(replyIdList)){
            return 1;
        }
        int i = replyMapper.replyRead(replyIdList);
        return i;
    }
}
