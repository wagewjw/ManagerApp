package com.wage.managerapp.mapper;

import com.wage.managerapp.entry.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    Account getAccount(Integer id);

    void insertAccount(Account account);
}
