package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class Collect {
    @Id
    private String openid;

    @Column(name = "article_id")
    private Long articleId;

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
     * @return article_id
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}