package com.xzj.gmall.gmallproduct;

//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzj.gmall.gmallproduct.entity.BrandEntity;
import com.xzj.gmall.gmallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GmallProductApplicationTests {


    @Autowired
    BrandService brandService;
//    @Autowired
//    OSSClient client;
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
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper();
        wrapper.eq("logo","LOVE");
        brandService.update(entity,wrapper);
        System.out.println("修改成功");
        System.out.println("======================"+brandService.getById(1l)+"======================");
        entity.setDescript("许兆举&&咸安慧");
        entity.setBrandId(1l);
        brandService.updateById(entity);
        System.out.println("======================"+brandService.getById(1l)+"======================");
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
//    @Test
//    public void update() throws FileNotFoundException {
//        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5tDqZoQ7Gv655PLfjArr";
//        String accessKeySecret = "tGUS5FHrQBwYEARIhycXAM1n6v2piC";
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        InputStream inputStream = new FileInputStream("D:\\bg.jpg");
//        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
//        ossClient.putObject("shoping-storage-server", "images/bg.png", inputStream);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//    }
//
//
//    @Test
//    public void updateByAlibaba() throws FileNotFoundException {
//
//        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        InputStream inputStream = new FileInputStream("D:\\bg.jpg");
//        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
//        client.putObject("shoping-storage-server", "images/bg.png", inputStream);
//
//        // 关闭OSSClient。
//        client.shutdown();
//    }



}
