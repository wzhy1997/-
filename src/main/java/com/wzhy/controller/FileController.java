package com.wzhy.controller;

import com.wzhy.pojo.StuHomework;
import com.wzhy.service.CouHomeworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class FileController {
//    定义日志
CouHomeworkService couHomeworkService;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "上传失败";
        }
        String fileName = file.getOriginalFilename();
        String  filePath = "Users/rain/Nocloud/temp/";
        File dest = new File(filePath + fileName);
//        上传
        try {
            file.transferTo(dest);

            logger.info("上传成功");
            StuHomework stuHomework = new StuHomework();
            stuHomework.setSubmitDate(new Date());
//            stuHomework.setMessage(dest);
//            couHomeworkService.postWork()
            System.out.println(dest.toString());
            return "上传成功";
        } catch (IOException e) {
            logger.info("上传失败");
            e.printStackTrace();
        }
        return "上传失败";
    }

}
