package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.PointsDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PointsDetailMapper extends MyMapper<PointsDetail> {
}