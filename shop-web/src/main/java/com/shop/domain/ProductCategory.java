package com.shop.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ym_shop_product_category")
public class ProductCategory {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 类别序列号
     */
    @Column(name = "category_code")
    private String categoryCode;

    /**
     * 首图的流水号
     */
    @Column(name = "img_id")
    private Long imgId;

    /**
     * 父类别id当id=0时说明是根节点,一级类别
     */
    private Long pid;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别状态1-正常,2-已废弃
     */
    private Boolean status;

    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建人ID
     */
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 最近操作人
     */
    @Column(name = "last_operator")
    private String lastOperator;

    /**
     * 最后操作人ID
     */
    @Column(name = "last_operator_id")
    private String lastOperatorId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取类别序列号
     *
     * @return category_code - 类别序列号
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 设置类别序列号
     *
     * @param categoryCode 类别序列号
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 获取首图的流水号
     *
     * @return img_id - 首图的流水号
     */
    public Long getImgId() {
        return imgId;
    }

    /**
     * 设置首图的流水号
     *
     * @param imgId 首图的流水号
     */
    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取父类别id当id=0时说明是根节点,一级类别
     *
     * @return pid - 父类别id当id=0时说明是根节点,一级类别
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父类别id当id=0时说明是根节点,一级类别
     *
     * @param pid 父类别id当id=0时说明是根节点,一级类别
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取类别名称
     *
     * @return name - 类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类别名称
     *
     * @param name 类别名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类别状态1-正常,2-已废弃
     *
     * @return status - 类别状态1-正常,2-已废弃
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置类别状态1-正常,2-已废弃
     *
     * @param status 类别状态1-正常,2-已废弃
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取排序编号,同类展示顺序,数值相等则自然排序
     *
     * @return sort_order - 排序编号,同类展示顺序,数值相等则自然排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序编号,同类展示顺序,数值相等则自然排序
     *
     * @param sortOrder 排序编号,同类展示顺序,数值相等则自然排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建人ID
     *
     * @return creator_id - 创建人ID
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人ID
     *
     * @param creatorId 创建人ID
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取最近操作人
     *
     * @return last_operator - 最近操作人
     */
    public String getLastOperator() {
        return lastOperator;
    }

    /**
     * 设置最近操作人
     *
     * @param lastOperator 最近操作人
     */
    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    /**
     * 获取最后操作人ID
     *
     * @return last_operator_id - 最后操作人ID
     */
    public String getLastOperatorId() {
        return lastOperatorId;
    }

    /**
     * 设置最后操作人ID
     *
     * @param lastOperatorId 最后操作人ID
     */
    public void setLastOperatorId(String lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}