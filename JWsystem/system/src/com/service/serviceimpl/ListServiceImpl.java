package com.service.serviceimpl;

import com.bean.CourseItem;
import com.dao.ListDao;
import com.dao.daoimpl.ListDaoImpl;
import com.service.ListService;

import java.util.List;

public class ListServiceImpl implements ListService {
    private ListDao listDao=new ListDaoImpl();
    @Override
    public void addCourseItem(CourseItem courseItem) {
        listDao.addCourseItem(courseItem);
    }

    @Override
    public void deleteCourceItem(Integer id) {
        listDao.deleteCourceItem(id);
    }

    @Override
    public List<CourseItem> queryCourseItem() {
       return listDao.queryCourseItem();
    }
}
