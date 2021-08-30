package com.xzj.gmall.gmallproduct.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xzj.gmall.gmallproduct.entity.CategoryEntity;
import com.xzj.gmall.gmallproduct.service.CategoryService;
import com.xzj.common.utils.PageUtils;
import com.xzj.common.utils.R;



/**
 * 商品三级分类
 *
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 14:34:26
 */
@RestController
@RequestMapping("gmallproduct/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    /**
     * 查询出所有分类的子类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    //@RequiresPermissions("gmallproduct:category:list")
    public R listTree(){
        List<CategoryEntity> list = categoryService.listWithTree();
        return R.ok().put("data",list);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("gmallproduct:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("gmallproduct:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("gmallproduct:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("gmallproduct:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("gmallproduct:category:delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
