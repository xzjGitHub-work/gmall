package com.xzj.gmall.gmallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.common.utils.PageUtils;
import com.xzj.gmall.gmallproduct.entity.CategoryEntity;

import java.util.List;
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

    /**
     * 查询出所有分类的子类，以树形结构组装起来
     */
    List<CategoryEntity> listWithTree();

    /**
     * @describe:批量删除
     *
     * @author:xzj
     * @createDate:2021/8/31 14:59
     * @param:[catIds]
     * @return:void
     */
    void removeByIdsAndList(List<Long> longs);
    /**
     * @describe:保存或者添加接口
     *
     * @author:xzj
     * @createDate:2021/9/1 17:31
     * @param:[category]
     * @return:void
     */
    void edit(CategoryEntity category);
}

