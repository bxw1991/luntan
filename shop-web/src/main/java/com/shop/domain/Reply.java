package com.shop.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_id")
    private Long commentId;


    /**
     * 评论用户openid
     */
    @Column(name = "from_openid")
    private String fromOpenid;


    @Column(name = "reply_id")
    private Long replyId;

    /**
     * 目标用户openid
     */
    @Column(name = "to_openid")
    private String toOpenid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "have_read")
    private Integer haveRead;

    @Column(name = "have_reply")
    private Integer haveReply;

    private String comment;

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
     * @return comment_id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取回去目标id
     *
     * @return reply_id - 回去目标id
     */


    /**
     * 设置回去目标id
     *
     * @param replyId 回去目标id
     */


    /**
     * 获取评论用户openid
     *
     * @return from_openid - 评论用户openid
     */
    public String getFromOpenid() {
        return fromOpenid;
    }

    /**
     * 设置评论用户openid
     *
     * @param fromOpenid 评论用户openid
     */
    public void setFromOpenid(String fromOpenid) {
        this.fromOpenid = fromOpenid;
    }

    /**
     * 获取目标用户openid
     *
     * @return to_openid - 目标用户openid
     */
    public String getToOpenid() {
        return toOpenid;
    }

    /**
     * 设置目标用户openid
     *
     * @param toOpenid 目标用户openid
     */
    public void setToOpenid(String toOpenid) {
        this.toOpenid = toOpenid;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return avatar_url
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    /**
     * @return have_read
     */
    public Integer getHaveRead() {
        return haveRead;
    }

    /**
     * @param haveRead
     */
    public void setHaveRead(Integer haveRead) {
        this.haveRead = haveRead;
    }

    /**
     * @return have_reply
     */
    public Integer getHaveReply() {
        return haveReply;
    }

    /**
     * @param haveReply
     */
    public void setHaveReply(Integer haveReply) {
        this.haveReply = haveReply;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }
}