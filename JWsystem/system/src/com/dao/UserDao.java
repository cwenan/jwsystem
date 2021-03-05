package com.dao;

import com.bean.Course;
import com.bean.User;

import java.net.InterfaceAddress;
import java.util.List;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * username用户名
     * 如果返回null,说明没有这个用户
     * */
    public User queryUserByUsername(String username);


    /**
    根据用户名和密码查询用户信息
    如果返回null,说明用户名或者密码错误
     */
    public User queryUserByUserAndPassword(String username,String password);


    //保存用户信息
    public int saveuser(User user);

    //查询用户信息
    public List<User>queryUsers();

    //删除用户
    public  int deleteUserById(Integer id);



}
