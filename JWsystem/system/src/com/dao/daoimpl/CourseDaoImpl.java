package com.dao.daoimpl;

import com.bean.Course;
import com.dao.BaseDao;
import com.dao.CourseDao;

import java.util.List;

public class CourseDaoImpl extends BaseDao implements CourseDao {
    @Override
    public int addCourse(Course course) {
        String sql="insert into t_course(coursename,teacher,classes,place,time)values(?,?,?,?,?)";
        return update(sql,course.getCoursename(),course.getTeacher(),course.getClasses(),course.getPlace(),course.getTime());

    }

    @Override
    public int deleteCourseById(Integer id) {
       String sql="delete from t_course where id=?";
       return update(sql,id);
    }

    @Override
    public int updateCourse(Course course) {
       String sql="update t_course set coursename=?,teacher=?,classes=?,place=?,time=?where id=?";
       return update(sql,course.getCoursename(),course.getTeacher(),course.getClasses(),course.getPlace(),course.getTime(),course.getId());
    }

    @Override
    public Course queryCourseById(Integer id) {
        String sql="select id,coursename,teacher,classes,place,time from t_course where id=?";
        return queryForOne(Course.class,sql,id);
    }

    @Override
    public List<Course> queryBooks() {
        String sql="select id,coursename,teacher,classes,place,time from t_course";
        return queryForList(Course.class,sql);
    }
}
