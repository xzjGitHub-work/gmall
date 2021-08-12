package com.xzj.gmall.gmallmember.controller;

import java.util.Arrays;
import java.util.Map;

import com.xzj.gmall.gmallmember.entity.MemberEntity;
import com.xzj.gmall.gmallmember.feign.GmallCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xzj.gmall.gmallmember.entity.GrowthChangeHistoryEntity;
import com.xzj.gmall.gmallmember.service.GrowthChangeHistoryService;
import com.xzj.common.utils.PageUtils;
import com.xzj.common.utils.R;



/**
 * 成长值变化历史记录
 *
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 16:13:31
 */
@RestController
@RequestMapping("gmallmember/growthchangehistory")
public class GrowthChangeHistoryController {
    @Autowired
    private GrowthChangeHistoryService growthChangeHistoryService;

    @Autowired
    private GmallCouponService gmallCoupon;

    @RequestMapping("/testFeignByMember")
    public R testFeignByMember() {
        MemberEntity entity = new MemberEntity();
        entity.setNickname("张三");
        R r = gmallCoupon.testFeign();
        return R.ok("success").put("member",entity)
                .put("coupon",r.get("coupon"));
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("gmallmember:growthchangehistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growthChangeHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("gmallmember:growthchangehistory:info")
    public R info(@PathVariable("id") Long id){
		GrowthChangeHistoryEntity growthChangeHistory = growthChangeHistoryService.getById(id);

        return R.ok().put("growthChangeHistory", growthChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("gmallmember:growthchangehistory:save")
    public R save(@RequestBody GrowthChangeHistoryEntity growthChangeHistory){
		growthChangeHistoryService.save(growthChangeHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("gmallmember:growthchangehistory:update")
    public R update(@RequestBody GrowthChangeHistoryEntity growthChangeHistory){
		growthChangeHistoryService.updateById(growthChangeHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("gmallmember:growthchangehistory:delete")
    public R delete(@RequestBody Long[] ids){
		growthChangeHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
