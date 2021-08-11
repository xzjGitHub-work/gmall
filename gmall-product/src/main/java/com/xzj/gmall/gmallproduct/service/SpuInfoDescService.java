package com.xzj.gmall.gmallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.common.utils.PageUtils;
import com.xzj.gmall.gmallproduct.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 14:34:26
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

