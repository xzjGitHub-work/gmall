package com.xzj.gmall.gmallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.common.utils.PageUtils;
import com.xzj.gmall.gmallproduct.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 14:34:26
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

