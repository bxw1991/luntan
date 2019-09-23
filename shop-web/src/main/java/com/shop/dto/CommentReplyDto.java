package com.shop.dto;

import com.shop.domain.Reply;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
public class CommentReplyDto {

    private Long id;

    private Long articleId;

    private String fromOpenid;

    private Date createTime;

    private String avatarUrl;

    private String nickName;

    private String comment;

    private List<Reply> replyList;
}
