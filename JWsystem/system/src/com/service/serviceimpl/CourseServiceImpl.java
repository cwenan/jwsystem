package com.service.serviceimpl;

import com.bean.Course;
import com.dao.CourseDao;
import com.dao.daoimpl.CourseDaoImpl;
import com.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao=new CourseDaoImpl();
    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseDao.deleteCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public Course queryCourseById(Integer id) {
      return   courseDao.queryCourseById(id);
    }

    @Override
    public List<Course> queryCourses() {
      return   courseDao.queryBooks();
    }
}
