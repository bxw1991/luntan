package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Article {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String openid;

    /**
     * 文章标题
     */
    private String subject;

    /**
     * 地点
     */
    private String place;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 地点类型 1=捡 2=丢
     */
    private Integer type;

    @Column(name = "image_urls")
    private String imageUrls;

    /**
     * 文章状态 1 正常 2已删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private Long looks;


    private BigDecimal latitude;

    private BigDecimal longitude;

    /**
     * 详细内容
     */
    private String content;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
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
     * 获取文章标题
     *
     * @return subject - 文章标题
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置文章标题
     *
     * @param subject 文章标题
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取地点
     *
     * @return place - 地点
     */
    public String getPlace() {
        return place;
    }

    /**
     * 设置地点
     *
     * @param place 地点
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 获取联系方式
     *
     * @return contact - 联系方式
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系方式
     *
     * @param contact 联系方式
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取地点类型 1=捡 2=丢
     *
     * @return type - 地点类型 1=捡 2=丢
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置地点类型 1=捡 2=丢
     *
     * @param type 地点类型 1=捡 2=丢
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return image_urls
     */
    public String getImageUrls() {
        return imageUrls;
    }

    /**
     * @param imageUrls
     */
    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    /**
     * 获取文章状态 1 正常 2已删除
     *
     * @return status - 文章状态 1 正常 2已删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置文章状态 1 正常 2已删除
     *
     * @param status 文章状态 1 正常 2已删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return looks
     */
    public Long getLooks() {
        return looks;
    }

    /**
     * @param looks
     */
    public void setLooks(Long looks) {
        this.looks = looks;
    }



    /**
     * @return latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * @return longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取详细内容
     *
     * @return content - 详细内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置详细内容
     *
     * @param content 详细内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}