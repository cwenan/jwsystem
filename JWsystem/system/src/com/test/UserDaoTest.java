package com.test;

import com.bean.User;
import com.dao.UserDao;
import com.dao.daoimpl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao=new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("root"));

    }

    @Test
    public void queryUserByUserAndPassword() {
        UserDao userDao =new UserDaoImpl();
        System.out.println(userDao.queryUserByUserAndPassword("admin","admin"));
    }

    @Test
    public void saveuser() {
        UserDao userDao=new UserDaoImpl();
        userDao.saveuser(new User(null,"cwenan","lll"));

    }
}