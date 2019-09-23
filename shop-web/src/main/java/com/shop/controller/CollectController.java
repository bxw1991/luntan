package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.common.core.support.BaseController;
import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import com.shop.domain.Article;
import com.shop.domain.Collect;
import com.shop.dto.CollectArticleDto;
import com.shop.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collect")
public class CollectController extends BaseController {

    @Autowired
    private CollectService collectService;

    @GetMapping("/getByOpenId")
    public Wrapper getByOpenId(Collect collect) {
        int byOpenId = collectService.getByOpenId(collect);
        return handleResult(byOpenId);
    }

    @PostMapping("/save")
    public Wrapper saveCollect(Collect collect) {
        int i = collectService.saveCollect(collect);
        return handleResult(i);
    }



    @PostMapping("/delete")
    public Wrapper delete(Collect collect) {
        int delete = collectService.delete(collect);
        return handleResult(delete);
    }

    @GetMapping("/articleListByOpenid")
    public  Wrapper articleListByOpenid(@RequestParam String openid,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo<CollectArticleDto> articlePageInfo = collectService.articleListByOpenid(openid, pageNum, pageSize);
        return WrapMapper.ok(articlePageInfo);
    }
}
