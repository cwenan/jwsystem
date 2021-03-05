package com.service;

import com.bean.Course;

import java.util.List;

public interface CourseService {
    public void addCourse(Course course);
    public void deleteCourseById(Integer id);
    public void updateCourse(Course book);
    public  Course queryCourseById(Integer id);
    public List<Course> queryCourses();
}
