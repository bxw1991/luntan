package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.common.base.dto.BaseQuery;
import com.shop.common.core.support.BaseController;
import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import com.shop.domain.Article;
import com.shop.dto.ArticleDetailDto;
import com.shop.dto.ArticleDto;
import com.shop.dto.BrifArticleDto;
import com.shop.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("/uploadImage")
    public Wrapper upLoadImage(@RequestParam(name = "file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String imageUrl = articleService.uploadImage(multipartFile);
        return WrapMapper.ok(imageUrl);
    }

    @PostMapping("/publish")
    public Wrapper publishArticle(ArticleDto articleDto){
        int insert = articleService.insert(articleDto);
        return handleResult(insert);
    }

    /**
     * 分页查询捡取信息
     * @param baseQuery
     * @return
     */
    @PostMapping("/pickList")
    @ApiOperation(httpMethod = "POST",value = "分页查询捡取信息")
    public Wrapper getPickList(BaseQuery baseQuery){
        PageInfo pageInfo = articleService.queryPickListWithPage(baseQuery);
        return WrapMapper.ok(pageInfo);
    }

    /**
     * 分页查询捡取信息
     * @param baseQuery
     * @return
     */
    @PostMapping("/loseList")
    @ApiOperation(httpMethod = "POST",value = "分页查询捡取信息")
    public Wrapper getLoseList(BaseQuery baseQuery){
        PageInfo pageInfo = articleService.queryLoseListWithPage(baseQuery);
        return WrapMapper.ok(pageInfo);
    }



    @PostMapping("/search")
    @ApiOperation(httpMethod = "POST",value = "关键词搜索")
    public Wrapper search(@RequestParam Integer type,@RequestParam String searchInfo,
                            @RequestParam Integer pageNum,@RequestParam  Integer pageSize){
        PageInfo search = articleService.search(type, searchInfo, pageNum, pageSize);
        return WrapMapper.ok(search);
    }

    @PostMapping("nearSearch")
    public Wrapper nearSearch(@RequestParam String searchInfo,
                              @RequestParam Integer pageNum,@RequestParam  Integer pageSize,
                              BigDecimal latitude, BigDecimal longitude){
        PageInfo nearSearch = articleService.nearSearch(searchInfo, pageNum, pageSize, latitude, longitude);
        return WrapMapper.ok(nearSearch);
    }

    @GetMapping("/brifList")
    @ApiOperation(httpMethod = "GET",value = "我发布的帖子")
    public Wrapper brifList(@RequestParam Integer type,@RequestParam String openid,@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize){
        PageInfo<BrifArticleDto> brifArticleDtoPageInfo = articleService.brifList(type, openid, pageNum, pageSize);
        return WrapMapper.ok(brifArticleDtoPageInfo);
    }

    @GetMapping("/deleteById")
    @ApiOperation(httpMethod = "GET",value = "根据id删除文章")
    public Wrapper deleteById(Long id){
//        Integer intId = Integer.parseInt(id);
        int i = articleService.deleteById(id);
        return handleResult(i);
    }

    @PostMapping("/deleteAll")
    public Wrapper deleteAll(@RequestParam Integer type){
        int i = articleService.deleteAll(type);
        return handleResult(i);
    }
    @GetMapping("/getArticleDetailById")
    public Wrapper getArticleDetailById(@RequestParam Long id){
        ArticleDetailDto articleDetailById = articleService.getArticleDetailById(id);
        return WrapMapper.ok(articleDetailById);
    }

    @GetMapping("/getTypeByArticleId")
    public Wrapper getTypeByArticleId(@RequestParam Long articleId){
        Integer typeByArticleId = articleService.getTypeByArticleId(articleId);
        return WrapMapper.ok(typeByArticleId);
    }

    @GetMapping("/getNearArticles")
    public Wrapper getNearArticles(@RequestParam BigDecimal latitude,@RequestParam BigDecimal longitude,
                                   @RequestParam Integer pageNum,Integer pageSize){
        PageInfo nearArticles = articleService.getNearArticles(latitude, longitude,pageNum,pageSize);
        return WrapMapper.ok(nearArticles);
    }
}
