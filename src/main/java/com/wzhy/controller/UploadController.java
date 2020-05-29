package com.wzhy.controller;

import com.wzhy.pojo.RespBean;
import com.wzhy.pojo.StuHomework;
import com.wzhy.pojo.User;
import com.wzhy.service.CouHomeworkService;
import com.wzhy.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UploadController {
    CouHomeworkService couHomeworkService;
    @Autowired
    HomeworkService homeworkService;
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
    @PostMapping("/import")
    public RespBean importData(MultipartFile file, HttpServletRequest req, @RequestParam("homeworkId") String homeworkId,StuHomework stuHomework) throws IOException {
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/upload") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder, newName));
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;
        System.out.println(url);
        stuHomework.setSubmitDate(new Date());
        stuHomework.setStudentId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        stuHomework.setHomeworkId(homeworkId);
        stuHomework.setMessage(url);
        stuHomework.setSubmitState("已提交");
        stuHomework.setSubmitCount("1");

        System.out.println(stuHomework);
        if(stuHomework!=null){
            homeworkService.postStuHomework(stuHomework);
        }
        System.out.println(stuHomework);
return null;
    }}