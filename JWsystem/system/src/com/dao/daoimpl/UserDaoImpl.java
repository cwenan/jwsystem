package com.dao.daoimpl;

import com.bean.Course;
import com.dao.BaseDao;
import com.dao.UserDao;
import com.bean.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql="select id,username,password from t_user where username=?";

        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUserAndPassword(String username, String password) {
        String sql="select id,username,password from t_user where username=?and password=?";

        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveuser(User user) {
        String sql="insert into t_user(username,password)values(?,?)";
        //为什么只需要三个值
        return update(sql,user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> queryUsers() {
        String sql="select * from t_user where not username ='admin' ";
        return queryForList(User.class, sql);
    }

    @Override
    public int deleteUserById(Integer id) {
        String sql="delete from t_user where id=?";
        return update(sql, id);
    }

}
