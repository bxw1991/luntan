package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.common.core.support.BaseController;
import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import com.shop.dto.CommentReadDto;
import com.shop.dto.MessageDto;
import com.shop.dto.ReplyReadDto;
import com.shop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/notRead")
    public Wrapper notReadByOpenId(@RequestParam String openid,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        PageInfo<MessageDto> messageDtoPageInfo = messageService.notReadByOpenId(openid, pageNum, pageSize);
        return WrapMapper.ok(messageDtoPageInfo);
    }
    @PostMapping("/haveRead")
    public Wrapper<Integer> haveRead(@RequestParam String openid){
        int i = messageService.haveRead(openid);
        return handleResult(i);
    }
    @GetMapping("/countByOpenid")
    public Wrapper countByOpenid(@RequestParam String openid){
        int i = messageService.countByOpenid(openid);
        return handleResult(i);
    }

    @PostMapping("/commentRead")
    public Wrapper commentRead(CommentReadDto commentReadDto){
        int i = messageService.commentRead(commentReadDto);
        return handleResult(i);
    }

    @PostMapping("/replyRead")
    public Wrapper replyRead(ReplyReadDto replyReadDto){
        int i = messageService.replyRead(replyReadDto);
        return handleResult(i);
    }
}
