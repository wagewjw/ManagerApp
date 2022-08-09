package com.wage.managerapp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wage.managerapp.entry.User;
import com.wage.managerapp.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
