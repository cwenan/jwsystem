package com.test;

import com.bean.Course;
import com.dao.CourseDao;
import com.dao.daoimpl.CourseDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDaoTest {
private CourseDao courseDao=new CourseDaoImpl();
    @Test
    public void addCourse() {
        courseDao.addCourse(new Course(null,"资本论","cwenan","一班，二班","大街上的小角落","today"));
    }

    @Test
    public void deleteCourseById() {
        courseDao.deleteCourseById(8);
    }

    @Test
    public void updateCourse() {
        courseDao.updateCourse(new Course(9,"资本论","憨憨","一班，二班","大街上的小角落","today"));
    }

    @Test
    public void queryCourseById() {
        System.out.println(courseDao.queryCourseById(9));
    }

    @Test
    public void queryBooks() {
        for (Course course:courseDao.queryBooks()){
            System.out.println(course);
            System.out.println("/n");
        }
    }
}