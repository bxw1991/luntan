package com.shop.controller;

import com.shop.common.core.support.BaseController;
import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import com.shop.domain.Comment;
import com.shop.dto.CommentReplyDto;
import com.shop.service.ArticleService;
import com.shop.service.CommentService;
import com.sun.nio.sctp.HandlerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public Wrapper save(Comment comment){
        int save = commentService.save(comment);
        return handleResult(save);
    }

    @GetMapping("/getCommentListByArticleId")
    public Wrapper getCommentListByArticleId(@RequestParam Long articleId){
        List<CommentReplyDto> commentReplyDtos = commentService.getcommentReplyDtoList(articleId);
        return WrapMapper.ok(commentReplyDtos);
    }

    @PostMapping("/deleteComment")
    public Wrapper deleteCommentById(@RequestParam(name = "commentId") Long id){
        int i = commentService.deleteById(id);
        return handleResult(i);
    }

}
