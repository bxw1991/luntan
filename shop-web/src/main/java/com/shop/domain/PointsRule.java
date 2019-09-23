package com.shop.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "points_rule")
public class PointsRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_content")
    private String ruleContent;

    @Column(name = "points_score")
    private Integer pointsScore;

    @Column(name = "is_set_upper")
    private Integer isSetUpper;

    @Column(name = "upper_value")
    private Integer upperValue;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

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
     * @return rule_content
     */
    public String getRuleContent() {
        return ruleContent;
    }

    /**
     * @param ruleContent
     */
    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
    }

    /**
     * @return points_score
     */
    public Integer getPointsScore() {
        return pointsScore;
    }

    /**
     * @param pointsScore
     */
    public void setPointsScore(Integer pointsScore) {
        this.pointsScore = pointsScore;
    }

    /**
     * @return is_set_upper
     */
    public Integer getIsSetUpper() {
        return isSetUpper;
    }

    /**
     * @param isSetUpper
     */
    public void setIsSetUpper(Integer isSetUpper) {
        this.isSetUpper = isSetUpper;
    }

    /**
     * @return upper_value
     */
    public Integer getUpperValue() {
        return upperValue;
    }

    /**
     * @param upperValue
     */
    public void setUpperValue(Integer upperValue) {
        this.upperValue = upperValue;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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