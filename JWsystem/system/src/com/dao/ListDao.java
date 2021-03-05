package com.dao;

import com.bean.CourseItem;

import java.util.List;

public interface ListDao {
public int addCourseItem(CourseItem courseItem);
public int deleteCourceItem(Integer id);
public List<CourseItem>queryCourseItem();

}

