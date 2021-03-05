package com.service.serviceimpl;

import com.dao.UserDao;
import com.dao.daoimpl.UserDaoImpl;
import com.bean.User;
import com.service.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao=new UserDaoImpl();
    @Override
    public void regisitUser(User user) {
        userDao.saveuser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            return false;
        }return true;
    }

    @Override
    public boolean existUser(String username, String password) {
        if (userDao.queryUserByUserAndPassword(username, password)==null){
            return false;
        }return true;
    }

    @Override
    public List<User> queryUsers() {
      return userDao.queryUsers();

    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }


}
