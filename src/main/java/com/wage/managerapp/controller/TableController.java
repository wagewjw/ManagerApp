package com.wage.managerapp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wage.managerapp.entry.User;
import com.wage.managerapp.exception.UserTooManyException;
import com.wage.managerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Resource
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
//        int i=10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                Model model){
//        List<User> users=Arrays.asList(new User("dahu","1312"),
//                new User("fafa","dasfas"),
//                new User("gfa","dfawfgadg"));
//        model.addAttribute("users",users);
//        if(users.size()>1){
//            throw new UserTooManyException();
//        }
//        List<User> list=userService.list();
//        model.addAttribute("users",list);

        Page<User> userPage=new Page<>(pn,2);
        Page<User> page=userService.page(userPage,null);
        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

}
