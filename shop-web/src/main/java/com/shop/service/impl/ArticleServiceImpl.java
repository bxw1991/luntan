package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.shop.common.base.dto.BaseQuery;
import com.shop.common.configProperties.properties.ShopProperties;
import com.shop.common.utils.PublicUtil;
import com.shop.common.utils.RandomUtil;
import com.shop.domain.*;
import com.shop.dto.ArticleDetailDto;
import com.shop.dto.ArticleDto;
import com.shop.dto.BrifArticleDto;
import com.shop.enums.ExceptionEnum;
import com.shop.exception.BusException;
import com.shop.mapper.*;
import com.shop.service.ArticleService;
import com.shop.vo.ArticlePageVo;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
//@Transactional(rollbackFor = BusException.class)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private Auth auth;
    @Autowired
    private ShopProperties shopProperties;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private PointsRuleMapper pointsRuleMapper;
    @Autowired
    private PointsDetailMapper pointsDetailMapper;
    @Autowired
    private PointsRewardMapper pointsRewardMapper;

    @Override
    public String uploadImage(MultipartFile multipartFile) throws IOException {

        if (multipartFile == null){
            throw new BusException(ExceptionEnum.MG00010.getCode(),ExceptionEnum.MG00010.getMessage());
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String type = StringUtils.substringAfterLast(originalFilename, ".");
        String picName = System.currentTimeMillis() + UUID.randomUUID().toString();
        String picPath  = shopProperties.getQiniuyun().getPicPath() + picName + "." + type;
        byte[] bytes = multipartFile.getBytes();
        uploadManager.put(bytes,picPath,auth.uploadToken(shopProperties.getQiniuyun().getPicBuket()));
        String picUrl = shopProperties.getQiniuyun().getOss().getPublicHost() + "/" + picPath;
        return picUrl;
    }

    @Override
    public int insert(ArticleDto articleDto) {
        Article article = new Article();
        String openid = articleDto.getOpenid();
        Integer pointsScore = 0;
        PointsDetail pointsDetail = new PointsDetail();
        pointsDetail.setOpenid(openid);
        pointsDetail.setPointsDate(new Date());
        if (articleDto.getType() == 1){
            PointsRule pointsRule = new PointsRule();
            pointsRule.setRuleContent("发布捡物");
            List<PointsRule> select = pointsRuleMapper.select(pointsRule);
            if (PublicUtil.isEmpty(select)){
                throw new BusException(10003,"积分规则不存在");
            }
            pointsScore = select.get(0).getPointsScore();

            pointsDetail.setPointsContent("发布捡物");
            pointsDetail.setPointsValue(pointsScore);
        }
        if (articleDto.getType() == 2){
            PointsRule pointsRule = new PointsRule();
            pointsRule.setRuleContent("发布失物");
            List<PointsRule> select = pointsRuleMapper.select(pointsRule);
            if (PublicUtil.isEmpty(select)){
                throw new BusException(10003,"积分规则不存在");
            }
            pointsScore = select.get(0).getPointsScore();
            pointsDetail.setPointsContent("发布失物");
            pointsDetail.setPointsValue(pointsScore);
        }
        PointsReward pointsReward = new PointsReward();
        pointsReward.setOpenid(openid);
        List<PointsReward> select = pointsRewardMapper.select(pointsReward);
        if (PublicUtil.isEmpty(select)){
            pointsReward.setRewardPoints(pointsScore);
            pointsRewardMapper.insert(pointsReward);
        }else {
            int points = select.get(0).getRewardPoints() + pointsScore;
            Long id = select.get(0).getId();
            pointsReward.setId(id);
            pointsReward.setRewardPoints(points);
            pointsRewardMapper.updateByPrimaryKey(pointsReward);
        }
        pointsDetailMapper.insert(pointsDetail);


        BeanUtils.copyProperties(articleDto,article);
        if (articleDto.getImageUrls() != null){
            List<String> imageUrls = articleDto.getImageUrls();
            article.setImageUrls(Joiner.on(",").join(imageUrls));
        }
        article.setStatus(1);
        article.setLooks(0L);
        int i = articleMapper.insert(article);
        return i;
    }


    @Override
    public PageInfo queryPickListWithPage(BaseQuery baseQuery) {
        PageHelper.startPage(baseQuery.getPageNum(),baseQuery.getPageSize());
        List<ArticlePageVo> articles = articleMapper.queryPickListByUpdateTimeDesc();
        return new PageInfo(articles);
    }

    @Override
    public PageInfo queryLoseListWithPage(BaseQuery baseQuery) {
        PageHelper.startPage(baseQuery.getPageNum(),baseQuery.getPageSize());
        List<ArticlePageVo> articles = articleMapper.queryLoseListByUpdateTimeDesc();
        return new PageInfo(articles);
    }

    @Override
    public PageInfo search(Integer type, String searchInfo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticlePageVo> searchList = articleMapper.search(type, searchInfo);
        return new PageInfo(searchList);
    }

    @Override
    public PageInfo nearSearch(String searchInfo, Integer pageNum, Integer pageSize,BigDecimal latitude, BigDecimal longitude) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticlePageVo> searchList = articleMapper.nearSearch(searchInfo,latitude,longitude);
        return new PageInfo(searchList);
    }

    @Override
    public PageInfo<BrifArticleDto> brifList(Integer type,String openid,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BrifArticleDto> brifArticleDtoList = articleMapper.selectBrifList(type, openid);
        return new PageInfo<BrifArticleDto>(brifArticleDtoList);
    }

    @Override
    public int deleteById(Long id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        article.setStatus(2);
        Long articleId = article.getId();
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        commentMapper.delete(comment);
        Reply reply = new Reply();
        reply.setArticleId(articleId);
        replyMapper.delete(reply);
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public int deleteAll(Integer type) {
        int delete = articleMapper.deleteAll(type);
        return delete;
    }

    @Override
    public ArticleDetailDto getArticleDetailById(Long id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        article.setLooks(article.getLooks() + 1);
        articleMapper.updateByPrimaryKeySelective(article);

        ArticleDetailDto articleDetailById = articleMapper.getArticleDetailById(id);
        if (articleDetailById != null){
            String imageUrls = articleDetailById.getImageUrls();
            if (imageUrls != null){
                String[] imageUrlsArray = StringUtils.split(imageUrls,",");
                articleDetailById.setImageUrlsArray(imageUrlsArray);
            }
            Comment comment = new Comment();
            comment.setArticleId(id);
            int i = commentMapper.selectCount(comment);
            articleDetailById.setCommentTimes(i);
        }

        return articleDetailById;
    }

    @Override
    public Integer getTypeByArticleId(Long id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        Integer type = article.getType();
        return type;
    }

    @Override
    public PageInfo getNearArticles(BigDecimal latitude, BigDecimal longitude, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticlePageVo> nearArticles = articleMapper.getNearArticles(latitude, longitude);
        return new PageInfo(nearArticles);
    }
}
