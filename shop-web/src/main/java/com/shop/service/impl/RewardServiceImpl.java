package com.shop.service.impl;

import com.shop.common.utils.PublicUtil;
import com.shop.domain.PointsReward;
import com.shop.exception.BusException;
import com.shop.mapper.PointsRewardMapper;
import com.shop.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {
    @Autowired
    private PointsRewardMapper pointsRewardMapper;
    @Override
    public int getReward(String openid) {
        PointsReward pointsReward = new PointsReward();
        pointsReward.setOpenid(openid);
        List<PointsReward> select = pointsRewardMapper.select(pointsReward);
        if (PublicUtil.isEmpty(select)){
          throw new BusException(10004,"用户积分不存在");
        }
        Integer rewardPoints = select.get(0).getRewardPoints();
        return rewardPoints;
    }
}
