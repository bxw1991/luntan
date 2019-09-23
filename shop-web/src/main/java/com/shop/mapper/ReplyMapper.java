package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.Reply;
import com.shop.dto.MessageDto;
import com.shop.dto.ReplyReadDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReplyMapper extends MyMapper<Reply> {
    List<MessageDto> notReadByOpenId(String openid);
    int haveRead(String openid);
    int replyRead(@Param("replyIdList")List<Long> replyIdList);
}