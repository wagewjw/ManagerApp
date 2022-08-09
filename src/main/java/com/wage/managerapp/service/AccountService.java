package com.wage.managerapp.service;

import com.wage.managerapp.entry.Account;
import com.wage.managerapp.mapper.AccountMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    AccountMapper accountMapper;

    public Account getAccountById(Integer id){
        return accountMapper.getAccount(id);
    }

    public void insertAccount(Account account){
        accountMapper.insertAccount(account);
    }
}
