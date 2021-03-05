package com.test;

import com.bean.Course;
import com.dao.CourseDao;
import com.dao.daoimpl.CourseDaoImpl;
import com.service.CourseService;
import com.service.serviceimpl.CourseServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseServiceTest {
    private CourseService courseService=new CourseServiceImpl();
    @Test
    public void addCourse() {
        courseService.addCourse(new Course(null,"数据库从删库到跑路","陈问安","一班，二班","综合楼102","zhoumo"));
    }

    @Test
    public void deleteCourseById() {
        courseService.deleteCourseById(9);
    }

    @Test
    public void updateCourse() {
        courseService.updateCourse(new Course(10,"数据库从入门到跑路","陈问安","二班，三班","教学楼129","今天"));
    }

    @Test
    public void queryCourseById() {
        System.out.println(courseService.queryCourseById(10));
    }

    @Test
    public void queryCourses() {
        for (Course course:courseService.queryCourses()){
            System.out.println(course);
        }
    }
}