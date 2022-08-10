package com.wage.managerapp;

import com.wage.managerapp.entry.User;
import com.wage.managerapp.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class ManagerAppApplicationTests {

    @Resource
//    @Autowired
    JdbcTemplate jdbcTemplate;

    @Resource
    UserMapper userMapper;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        Long num=jdbcTemplate.queryForObject("select count(*) from account_tbl",Long.class);
        log.info(String.valueOf(num));
    }

    @Test
    void testUserMapper(){
        User user=userMapper.selectById(1);
        log.info(String.valueOf(user));
    }

    @Test
    void testRedis(){
        ValueOperations<String,String> valueOperations=stringRedisTemplate.opsForValue();
        valueOperations.set("dsa","dasfgas");
        String dsa=valueOperations.get("dsa");
        log.info("测试："+dsa);
    }

}
