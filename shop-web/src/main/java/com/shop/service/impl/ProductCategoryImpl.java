package com.shop.service.impl;

import com.shop.common.base.exception.BusinessException;
import com.shop.common.utils.ConverUtil;
import com.shop.common.utils.PublicUtil;
import com.shop.common.utils.WrapMapper;
import com.shop.domain.ProductCategory;
import com.shop.mapper.ProductCategoryMapper;
import com.shop.service.ProductCategoryService;
import com.shop.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductCategoryImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<CategoryVo> getCategoryList() {
        List<ProductCategory> productCategoryList = productCategoryMapper.selectAll();
        if (PublicUtil.isEmpty(productCategoryList)) {
            throw new BusinessException("类目列表为空");
        }
        List<CategoryVo> categoryVoList = productCategoryList.stream().map(e -> ConverUtil.convert(e,new CategoryVo())).collect(Collectors.toList());
        return categoryVoList;
    }
}
