package com.shop.service;

import com.shop.domain.Comment;
import com.shop.dto.CommentReplyDto;

import java.util.List;

public interface CommentService {
    int save(Comment comment);
//    List<Comment> getCommentListByArticleId(Long articleId);
    List<CommentReplyDto> getcommentReplyDtoList(Long articleId);
    int deleteById(Long id);
}
