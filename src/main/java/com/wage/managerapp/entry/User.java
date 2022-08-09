package com.wage.managerapp.entry;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
