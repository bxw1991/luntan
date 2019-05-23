package com.shop.service;

import com.shop.common.utils.Wrapper;
import com.shop.vo.WeChatInfo;

public interface WeChatService {
    WeChatInfo getWeChatInfo(String code);

    boolean checkToken(String token);
}
