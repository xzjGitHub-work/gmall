package com.xzj.gmall.gmallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.common.utils.PageUtils;
import com.xzj.gmall.gmallproduct.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 14:34:26
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

