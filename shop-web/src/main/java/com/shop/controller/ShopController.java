package com.shop.controller;



import com.shop.common.utils.WrapMapper;
import com.shop.common.utils.Wrapper;
import com.shop.domain.ProductInfo;
import com.shop.mapper.ProductInfoMapper;
import com.shop.service.ProductCategoryService;
import com.shop.vo.CategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/shop")
@Api(value = "Web-ProductController",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ShopController {

    @Autowired
    private ProductCategoryService productCategoryService;


    /***
     * 小程序简化类目操作，只分一级类目，非类目树
     * @return
     */
    @GetMapping("/goods/category/all")
    @ApiOperation(httpMethod = "GET",value = "获取商品类目")
    public Wrapper<List<CategoryVo>> listCategory() {
        List<CategoryVo> categoryList = productCategoryService.getCategoryList();
        return WrapMapper.ok(categoryList);
    }


}
