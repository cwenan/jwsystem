package com.web;

import com.bean.Course;
import com.service.CourseService;
import com.service.serviceimpl.CourseServiceImpl;
import com.utils.webUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private CourseService courseService=new CourseServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取请求的参数
        Course course=new Course();
        BeanUtils.populate(course,req.getParameterMap());
        courseService.addCourse(course);
        resp.sendRedirect(req.getContextPath()+"/CourseServlet?action=list");
//        req.getRequestDispatcher("/pages/course/course_manage.jsp").forward(req,resp);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取id的值
         * 调用utils方法完成转型
         * 重定向到list页面
         */
        int id=webUtils.parseInt(req.getParameter("id"));
        courseService.deleteCourseById(id);
        resp.sendRedirect(req.getContextPath()+"/CourseServlet?action=list");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //获取请求的参数
        Course course=new Course();
        BeanUtils.populate(course, req.getParameterMap());
        courseService.updateCourse(course);
        resp.sendRedirect(req.getContextPath()+"/CourseServlet?action=list");
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过bookservice查询全部课程
        List<Course>courses=courseService.queryCourses();
        //把课程保存到request域里面
        req.setAttribute("courses",courses);
        //请求转发到管理页面
        req.getRequestDispatcher("/pages/course/course_manage.jsp").forward(req,resp);
    }
    protected void getCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取请求的课程id
        int id=webUtils.parseInt(req.getParameter("id"));
            //查询到具体课程
        Course course=courseService.queryCourseById(id);
        //保存到request域里
        req.setAttribute("course",course);
        //转发到编辑页面
        req.getRequestDispatcher("/pages/course/course_edit.jsp").forward(req,resp);
    }

    protected void listItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过bookservice查询全部课程
        List<Course>courses=courseService.queryCourses();
        //把课程保存到request域里面
        req.setAttribute("courses",courses);
        //请求转发到管理页面
        req.getRequestDispatcher("/pages/courselist/addcourse.jsp").forward(req,resp);
    }
}
