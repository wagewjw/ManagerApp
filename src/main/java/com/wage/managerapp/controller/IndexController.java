package com.wage.managerapp.controller;

import com.wage.managerapp.entry.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 去login.html
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession httpSession, Model model){
        if((!StringUtils.isEmpty(user.getUserName()))&&"123456".equals(user.getPassword())){
            httpSession.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
        //登录成功重定向到main.html->重定向防止页面重复提交
    }

    /**
     * 去main.html
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession httpSession,Model model){
        Object loginUser=httpSession.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }

}
