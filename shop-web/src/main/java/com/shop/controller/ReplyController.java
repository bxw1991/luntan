package com.shop.controller;

import com.shop.common.core.support.BaseController;
import com.shop.common.utils.Wrapper;
import com.shop.domain.Reply;
import com.shop.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public class ReplyController extends BaseController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/save")
    public Wrapper save(Reply reply){
        int save = replyService.save(reply);
        return handleResult(save);
    }
    @PostMapping("/deleteById")
    public Wrapper deleteById(@RequestParam  Long id){
        int i = replyService.deleteById(id);
        return handleResult(i);
    }
}
