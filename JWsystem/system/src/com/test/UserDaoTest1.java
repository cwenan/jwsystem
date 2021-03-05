package com.test;

import com.bean.User;
import com.dao.UserDao;
import com.dao.daoimpl.UserDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest1 {
private UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUsers() {
        List<User>users= userDao.queryUsers();
        for (User user:users){
            System.out.println(user);
        }
    }
}