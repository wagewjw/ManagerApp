package com.wage.managerapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String sendFile(){
        return "/page/form_layouts";
    }

    /**
     * MultipartFile自动封装文件
     * @param email
     * @param userName
     * @param headerImage
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName") String userName,
                         @RequestPart("headerImage")MultipartFile headerImage,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {
        log.info("上传信息：邮箱={}，名字={}，头像={}，生活照={}",email,userName,headerImage.getSize(),photos.length);
        if(!headerImage.isEmpty()){
            String headerImageName=headerImage.getOriginalFilename();
            headerImage.transferTo(new File("D:\\cache\\"+headerImageName));
        }
        if(photos.length!=0){
            for (MultipartFile m :
                    photos) {
                String mName = m.getOriginalFilename();
                m.transferTo(new File("D:\\cache\\"+mName));
            }
        }
        return "main";
    }
}
