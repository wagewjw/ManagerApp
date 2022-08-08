package com.wage.managerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.wage.managerapp")
@SpringBootApplication
public class ManagerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerAppApplication.class, args);
    }

}
