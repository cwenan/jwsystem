package com.test;

import com.bean.CourseItem;
import com.dao.ListDao;
import com.dao.daoimpl.ListDaoImpl;
import org.junit.Test;

public class ListDaoTest {
private ListDao listDao=new ListDaoImpl();
    @Test
    public void addCourseItem() {
        listDao.addCourseItem(new CourseItem(null,"高等数学","李老师"));
    }

    @Test
    public void deleteCourceItem() {
        listDao.deleteCourceItem(1);
    }

    @Test
    public void queryCourseItem() {
        listDao.queryCourseItem();
    }
}