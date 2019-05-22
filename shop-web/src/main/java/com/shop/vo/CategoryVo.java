package com.shop.vo;
import com.shop.common.base.dto.BaseTree;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class CategoryVo implements Serializable {
    private static final long serialVersionUID = 5310269803239754048L;

    private Long id;

    private String name;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    private Integer sortOrder;
    /**
     * 分类编码
     */
    private String categoryCode;
}
