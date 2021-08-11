package com.xzj.gmall.gmallproduct;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzj.common.utils.PageUtils;
import com.xzj.gmall.gmallproduct.entity.BrandEntity;
import com.xzj.gmall.gmallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GmallProductApplicationTests {


    @Autowired
    private BrandService brandService;
    /**
     * @describe:增加
     *
     * @author:xzj
     * @createDate:2021/8/11 14:40
     * @param:[]
     * @return:void
     */
    @Test
    void contextLoadsBySave() {
        BrandEntity entity = new BrandEntity();
        entity.setDescript("描述");
        entity.setFirstLetter("x");
        entity.setName("咸安慧");
        entity.setLogo("LOVE");
        entity.setSort(1);
        entity.setShowStatus(1);
        brandService.save(entity);
    }

    /**
     * @describe:修改
     *
     * @author:xzj
     * @createDate:2021/8/11 14:42
     * @param:[]
     * @return:void
     */
    @Test
    void contextLoadsByUpdate() {
        BrandEntity entity = new BrandEntity();
        entity.setDescript("咸安慧&&许兆举");
        entity.setBrandId(1l);

        QueryWrapper<BrandEntity> wrapper = new QueryWrapper();

        brandService.update(wrapper);
        brandService.updateById(entity);
    }

    /**
     * @describe:删除
     *
     * @author:xzj
     * @createDate:2021/8/11 14:42
     * @param:[]
     * @return:void
     */
    @Test
    void contextLoadsByRm() {
        BrandEntity entity = new BrandEntity();
        entity.setDescript("描述");
        entity.setFirstLetter("x");
        entity.setName("咸安慧");
        entity.setLogo("LOVE");
        entity.setSort(1);
        entity.setShowStatus(1);
        brandService.save(entity);
    }
    /**
     * @describe:查询
     *
     * @author:xzj
     * @createDate:2021/8/11 14:42
     * @param:[]
     * @return:void
     */
    @Test
    void contextLoadsBySelect() {
        BrandEntity entity = new BrandEntity();
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("brand_id",1l);
        List<BrandEntity> list = brandService.list(wrapper);
        for (BrandEntity brandEntity : list) {
            System.out.println(brandEntity);
        }
    }

}
