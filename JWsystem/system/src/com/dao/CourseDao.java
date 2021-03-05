package com.dao;

import com.bean.Course;

import java.util.List;

public interface CourseDao {
    public int addCourse(Course course);
    public int deleteCourseById(Integer id);
    public int updateCourse(Course course);
    public Course queryCourseById(Integer id);
    public List<Course>queryBooks();
}
