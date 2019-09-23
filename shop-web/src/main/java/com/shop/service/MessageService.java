package com.shop.service;

import com.github.pagehelper.PageInfo;
import com.shop.dto.CommentReadDto;
import com.shop.dto.MessageDto;
import com.shop.dto.ReplyReadDto;

import java.util.List;

public interface MessageService {
    PageInfo<MessageDto> notReadByOpenId(String openid, Integer pageNum, Integer pageSize);
    int haveRead(String openid);
    int countByOpenid(String openid);
    int commentRead(CommentReadDto commentReadDto);
    int replyRead(ReplyReadDto replyReadDto);
}
