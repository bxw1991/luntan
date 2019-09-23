package com.shop.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "points_detail")
public class PointsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "points_state")
    private Integer pointsState;

    @Column(name = "points_date")
    private Date pointsDate;

    @Column(name = "points_content")
    private String pointsContent;

    @Column(name = "points_value")
    private Integer pointsValue;

    private String remark;

    @Column(name = "points_rule")
    private Integer pointsRule;

    private String field01;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return points_state
     */
    public Integer getPointsState() {
        return pointsState;
    }

    /**
     * @param pointsState
     */
    public void setPointsState(Integer pointsState) {
        this.pointsState = pointsState;
    }

    /**
     * @return points_date
     */
    public Date getPointsDate() {
        return pointsDate;
    }

    /**
     * @param pointsDate
     */
    public void setPointsDate(Date pointsDate) {
        this.pointsDate = pointsDate;
    }

    /**
     * @return points_content
     */
    public String getPointsContent() {
        return pointsContent;
    }

    /**
     * @param pointsContent
     */
    public void setPointsContent(String pointsContent) {
        this.pointsContent = pointsContent;
    }

    /**
     * @return points_value
     */
    public Integer getPointsValue() {
        return pointsValue;
    }

    /**
     * @param pointsValue
     */
    public void setPointsValue(Integer pointsValue) {
        this.pointsValue = pointsValue;
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
     * @return points_rule
     */
    public Integer getPointsRule() {
        return pointsRule;
    }

    /**
     * @param pointsRule
     */
    public void setPointsRule(Integer pointsRule) {
        this.pointsRule = pointsRule;
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
}