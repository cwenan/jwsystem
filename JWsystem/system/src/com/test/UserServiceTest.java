package com.test;

import com.bean.User;
import com.service.UserService;
import com.service.serviceimpl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

UserService service=new UserServiceImpl();
    @Test
    public void regisitUser() {
service.regisitUser(new User(null,"aaa","llkadj"));
    }

    @Test
    public void login() {
        System.out.println(service.login(new User(null,"admin","admin")));
    }

    @Test
    public void existUsername() {
        System.out.println(service.existUsername("hahaha"));
    }
}