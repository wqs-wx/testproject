package com.mytest.testproject.controller;

import com.fhparser.FetalInfo;
import com.fhparser.FetalParserLib;
import com.mytest.testproject.service.FHDataCallbackImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author wqs
 * @version 1.0
 * @date 2021/4/8 10:18
 */
@Slf4j
@RestController
public class FHParserController {
    private static String configPath = "E:/work/fhConfig/";

    @RequestMapping(value = "/parserData", method = RequestMethod.PUT)
    public String parserData(@RequestParam("filePath") String filePath) {
        FetalParserLib.init();

        //第一步: 设置存储路径
        String storagePath = configPath;
        FetalParserLib.setStoragePath(storagePath);

        FetalParserLib.loadChannelId(0);

        //第三步: 设置数据回调
        FHDataCallbackImpl fhDataCallback = new FHDataCallbackImpl();
        FetalParserLib.setCallback(0, fhDataCallback);

        testStringFile(filePath);

        return "调用成功";
    }

    private void testStringFile(String filePath) {
        try {
            URL httpUrl = new URL(filePath);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // 得到输入流
            InputStream in = conn.getInputStream();
            byte[] tempbytes = new byte[128];

            FetalInfo fetalInfo = new FetalInfo();
            fetalInfo.username = "测试人员";
            fetalInfo.userInfoId = "12345646";

            FetalParserLib.startMonitor(0, fetalInfo);

            int byteread = 0;
            while ((byteread = in.read(tempbytes)) != -1) {
                //数据解析
                FetalParserLib.analyseData(0, tempbytes);
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            FetalParserLib.stopMonitor(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
