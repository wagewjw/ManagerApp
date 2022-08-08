package com.wage.managerapp.exception;

import com.wage.managerapp.entry.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量大于1")
public class UserTooManyException extends RuntimeException{

    public UserTooManyException(){}

    public UserTooManyException(String message){
        super(message);
    }

}
