package com.xzj.gmall.gmallcoupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xzj.gmall.gmallcoupon.entity.CouponEntity;
import com.xzj.gmall.gmallcoupon.service.CouponService;
import com.xzj.common.utils.PageUtils;
import com.xzj.common.utils.R;



/**
 * 优惠券信息
 *
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 16:10:37
 */
@RestController
@RequestMapping("gmallcoupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;


    /**
     * @describe:测试Feign
     *
     * @author:xzj
     * @createDate:2021/8/12 0:15
     * @param:
     * @return:
     */
    @RequestMapping("/testFeign")
    public R testFeign(){
        CouponEntity entity = new CouponEntity();
        entity.setCouponName("许兆举&咸安慧");
        return R.ok("success").put("coupon",Arrays.asList(entity));
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("gmallcoupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("gmallcoupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("gmallcoupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("gmallcoupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("gmallcoupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
