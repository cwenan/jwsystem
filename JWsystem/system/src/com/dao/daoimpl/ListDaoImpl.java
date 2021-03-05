package com.dao.daoimpl;

import com.bean.CourseItem;
import com.dao.BaseDao;
import com.dao.ListDao;

import java.util.List;

public class ListDaoImpl extends BaseDao implements ListDao {
    @Override
    public int addCourseItem(CourseItem courseItem) {
        String sql="insert into t_courselist(name,teacher)values(?,?)";
        return update(sql, courseItem.getName(),courseItem.getTeacher());
    }

    @Override
    public int deleteCourceItem(Integer id) {
        String sql="delete from t_courselist where id=?";
        return update(sql, id);
    }

    @Override
    public List<CourseItem> queryCourseItem() {
        String sql="select id,name,teacher from t_courselist";
        return queryForList(CourseItem.class, sql);
    }
}
