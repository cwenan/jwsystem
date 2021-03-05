package com.test;

import com.bean.User;
import com.service.UserService;
import com.service.serviceimpl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest1 {
private UserService userService=new UserServiceImpl();
    @Test
    public void queryUsers() {
        List<User> users=
        userService.queryUsers();
        for (User user:users){
            System.out.println(user);
        }
    }
}