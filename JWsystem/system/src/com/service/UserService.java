package com.service;

import com.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 注册用户
     * user
     */
    public void regisitUser(User user);

    /**
     * 登录
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     *
     */
    public boolean existUsername(String username);

    public boolean existUser(String username,String password);

    public List<User> queryUsers();

    public void  deleteUserById(Integer id);


}


