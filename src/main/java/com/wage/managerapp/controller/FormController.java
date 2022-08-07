package com.wage.managerapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/form_file")
    public String sendFile(){
        return "/page/form_layouts";
    }
}
