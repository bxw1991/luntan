package com.shop.service;

import com.shop.common.utils.Wrapper;
import com.shop.domain.User;
import com.shop.dto.UserDto;
import com.shop.vo.WeChatInfo;

public interface WeChatService {
    WeChatInfo getWeChatInfo(UserDto userDto);

    boolean checkToken(String token);
}
