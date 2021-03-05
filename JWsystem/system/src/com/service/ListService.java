package com.service;

import com.bean.CourseItem;

import java.util.List;

public interface ListService {
    public void addCourseItem(CourseItem courseItem);
    public void deleteCourceItem(Integer id);
    public List<CourseItem> queryCourseItem();
}
