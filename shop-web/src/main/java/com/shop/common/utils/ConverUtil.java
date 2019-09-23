package com.shop.common.utils;

import org.springframework.beans.BeanUtils;

public class ConverUtil {

    public static <T, K> K convert(T t, K k) {
        BeanUtils.copyProperties(t, k);
        return k;
    }
}
