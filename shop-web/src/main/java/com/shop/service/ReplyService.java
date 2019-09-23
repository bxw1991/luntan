package com.shop.service;

import com.shop.domain.Reply;
import com.shop.dto.MessageDto;

import java.util.List;

public interface ReplyService {
    int save(Reply reply);
    int deleteById(Long id);

}
