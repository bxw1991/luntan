package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CommentMapper extends MyMapper<Comment> {
    int haveRead(String openid);
    int batchRead(@Param("commentIdList") List<Long> commentIdList);
}