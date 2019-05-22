package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductInfoMapper extends MyMapper<ProductInfo> {
}