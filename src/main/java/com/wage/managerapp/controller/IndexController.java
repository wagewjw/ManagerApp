package com.wage.managerapp.controller;

import com.wage.managerapp.entry.Account;
import com.wage.managerapp.entry.User;
import com.wage.managerapp.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.PushBuilder;

@Slf4j
@Controller
public class IndexController {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    AccountService accountService;

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
        log.info(user.getUserName()+":"+user.getPassword());
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
//        Object loginUser=httpSession.getAttribute("loginUser");
//        if(loginUser!=null){
//            return "main";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        return "main";
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long num=jdbcTemplate.queryForObject("select count(*) from account_tbl",Long.class);
        return num.toString();
    }

    @ResponseBody
    @GetMapping("/account")
    public Account getById(@RequestParam("id") Integer id){
        return accountService.getAccountById(id);
    }

    @ResponseBody
    @PostMapping("/account")
    public Account insertAccount(Account account){
        accountService.insertAccount(account);
        log.info("id={},name={},email={}",account.getId(),account.getName(),account.getEmail());
        return account;
    }

}
