package com.xzj.gmall.gmallmember.feign;

import com.xzj.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 测试Feign
 * @Author: xzj
 * @CreateDate: 2021/8/12 0:21
 */
@FeignClient(name = "gmall-coupon")
public interface GmallCouponService {

    @RequestMapping("/gmallcoupon/coupon/testFeign")
    R testFeign();
}
