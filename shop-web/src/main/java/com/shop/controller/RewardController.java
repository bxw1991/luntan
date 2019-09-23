package com.shop.controller;

import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import com.shop.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/getReward")
    public Wrapper getReward(@RequestParam String openid){
        int reward = rewardService.getReward(openid);
        return WrapMapper.ok(reward);
    }
}
