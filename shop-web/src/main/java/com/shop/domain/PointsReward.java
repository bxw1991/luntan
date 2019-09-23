package com.shop.domain;

import javax.persistence.*;

@Table(name = "points_reward")
public class PointsReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String openid;

    @Column(name = "reward_points")
    private Integer rewardPoints;

    private String remark;

    private String field01;

    private String field02;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return reward_points
     */
    public Integer getRewardPoints() {
        return rewardPoints;
    }

    /**
     * @param rewardPoints
     */
    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return field01
     */
    public String getField01() {
        return field01;
    }

    /**
     * @param field01
     */
    public void setField01(String field01) {
        this.field01 = field01;
    }

    /**
     * @return field02
     */
    public String getField02() {
        return field02;
    }

    /**
     * @param field02
     */
    public void setField02(String field02) {
        this.field02 = field02;
    }
}