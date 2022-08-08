package com.wage.managerapp.controller;

import com.wage.managerapp.entry.User;
import com.wage.managerapp.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        int i=10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users=Arrays.asList(new User("dahu","1312"),
                new User("fafa","dasfas"),
                new User("gfa","dfawfgadg"));
        model.addAttribute("users",users);
        if(users.size()>1){
            throw new UserTooManyException();
        }
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
