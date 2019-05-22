package com.shop.mapper;

import com.shop.common.core.mybatis.MyMapper;
import com.shop.domain.ProductCategory;
import com.shop.vo.CategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProductCategoryMapper extends MyMapper<ProductCategory> {

    List<CategoryVo> listCategoryVo();
}