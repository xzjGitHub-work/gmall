package com.xzj.gmall.gmallproduct;

import com.xzj.common.utils.PageUtils;
import com.xzj.gmall.gmallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GmallProductApplicationTests {


    @Autowired
    private BrandService brandService;
    @Test
    void contextLoads() {
        PageUtils pageUtils = brandService.queryPage(null);

    }

}
