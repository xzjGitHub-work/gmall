package com.xzj.gmall.gmallproduct.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.common.utils.PageUtils;
import com.xzj.common.utils.Query;

import com.xzj.gmall.gmallproduct.dao.CategoryDao;
import com.xzj.gmall.gmallproduct.entity.CategoryEntity;
import com.xzj.gmall.gmallproduct.service.CategoryService;
import org.springframework.util.ObjectUtils;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> list = baseMapper.selectList(null);
        //查询父类的标签
        List<CategoryEntity> fatherList = list.stream()
                //查找父类
                .filter(o -> o.getParentCid() == 0)
                //找到子类
                .map(o -> {
                    o.setChild(getChildList(o, list));
                    return o;
                })
                //排序
                .sorted((n1, n2) -> {
                    return (n1.getSort() == null ? 0 : n1.getSort()) - (n2.getSort() == null ? 0 : n2.getSort());
                }).collect(Collectors.toList());
        return fatherList;
    }

    @Override
    public void removeByIdsAndList(List<Long> longs) {
        //todo 校验是否被依赖
        baseMapper.deleteBatchIds(longs);
    }

    @Override
    public void edit(CategoryEntity category) {
        if (ObjectUtils.isEmpty(category.getCatId())){
            baseMapper.insert(category);
        }else {
            baseMapper.updateById(category);
        }
    }

    public List<CategoryEntity> getChildList(CategoryEntity categoryEntity, List<CategoryEntity> list) {
        return list.stream()
                .filter(o -> categoryEntity.getCatId() - o.getParentCid() == 0 )
                .map(o -> {
                    o.setChild(getChildList(o, list));
                    return o;
                })
                .sorted((n1, n2) -> {
                    return (n1.getSort() == null ? 0 : n1.getSort()) - (n2.getSort() == null ? 0 : n2.getSort());
                }).collect(Collectors.toList());

    }


}