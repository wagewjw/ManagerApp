package com.wage.managerapp.config;

import com.wage.managerapp.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //所有请求（包括静态资源）都会被拦截
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/js/**","/images/**");
    }
}
