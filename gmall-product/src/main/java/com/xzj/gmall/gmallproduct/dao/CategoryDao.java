package com.xzj.gmall.gmallproduct.dao;

import com.xzj.gmall.gmallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 10:44:28
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
