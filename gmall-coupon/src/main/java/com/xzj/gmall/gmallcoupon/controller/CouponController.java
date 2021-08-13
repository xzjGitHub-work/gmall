package com.xzj.gmall.gmallcoupon.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
@RestController
@RequestMapping("gmallcoupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;


    @Value("${user.name-Id}")
    String name ;
    @Value("${user.age}")
    Integer age ;
    @Value("${user.gender}")
    String gender ;

    /**
     * @describe:之前获取配置中心的数据
     *
     * @author:xzj
     * @createDate:2021/8/12 15:28
     * @param:[]
     * @return:java.lang.String
     */
    @RequestMapping("/testConfigByLocalYml")
    public R testConfigByLocalYml(){
        Map<String,String> map = new HashMap<>(8);
        map.put("name",name);
        map.put("age",age+"");
        map.put("gender",gender);
        return R.ok().put("data",map);
    }
    @Value("${user.name.properties}")
    String userName;

    @Value("${user.age.properties}")
    String userAge;

    @Value("${user.gender.properties}")
    String userGender;

    @Value("${user.properties.name}")
    String userNameByProperties;
    /**
     * @describe:测试在nacos中获取数据
     *
     * @author:xzj
     * @createDate:2021/8/12 16:38
     * @param:[]
     * @return:com.xzj.common.utils.R
     */
    @RequestMapping("/testConfigByNacosProperties")
    public R testConfigByNacosProperties(){
        Map<String,String> map = new HashMap<>(8);
        map.put("userName",userName);
        map.put("userAge",userAge+"");
        map.put("userGender",userGender);
        map.put("userNameByProperties",userNameByProperties);
        return R.ok().put("data",map);
    }
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
