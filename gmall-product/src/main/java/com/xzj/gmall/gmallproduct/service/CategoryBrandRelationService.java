package com.xzj.gmall.gmallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.common.utils.PageUtils;
import com.xzj.gmall.gmallproduct.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 14:34:26
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

