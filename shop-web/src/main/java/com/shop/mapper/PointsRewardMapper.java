package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.PointsReward;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PointsRewardMapper extends MyMapper<PointsReward> {
}