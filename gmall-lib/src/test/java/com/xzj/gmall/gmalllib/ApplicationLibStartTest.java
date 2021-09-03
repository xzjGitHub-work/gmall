package com.xzj.gmall.gmalllib;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/9/2 17:36
 */
@SpringBootTest
public class ApplicationLibStartTest {
    @Autowired
    OSSClient client;

    @Test
    public void updateByAlibaba() throws FileNotFoundException {

        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        InputStream inputStream = new FileInputStream("D:\\bg.jpg");
        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        client.putObject("shoping-storage-server", "images/bg2.png", inputStream);

        // 关闭OSSClient。
        client.shutdown();
    }

}
