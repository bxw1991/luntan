package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class User {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户openid
     */
    private String openid;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 性别 0-男 1-女
     */
    private Integer gender;

    /**
     * 国家
     */
    private String country;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 语种
     */
    private String language;

    /**
     * 创建/注册时间
     */
    private Date ctime;

    /**
     * 手机号码
     */
    private String mobile;

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
     * 获取用户openid
     *
     * @return openid - 用户openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置用户openid
     *
     * @param openid 用户openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取用户头像
     *
     * @return avatar_url - 用户头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置用户头像
     *
     * @param avatarUrl 用户头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 获取性别 0-男 1-女
     *
     * @return gender - 性别 0-男 1-女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别 0-男 1-女
     *
     * @param gender 性别 0-男 1-女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取所在省份
     *
     * @return province - 所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省份
     *
     * @param province 所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取语种
     *
     * @return language - 语种
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置语种
     *
     * @param language 语种
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取创建/注册时间
     *
     * @return ctime - 创建/注册时间
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * 设置创建/注册时间
     *
     * @param ctime 创建/注册时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}