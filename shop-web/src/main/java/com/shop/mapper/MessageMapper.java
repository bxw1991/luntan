package com.shop.mapper;

import com.shop.dto.CommentReadDto;
import com.shop.dto.MessageDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageMapper {
    List<MessageDto> notReadByOpenId(String openid);

}
