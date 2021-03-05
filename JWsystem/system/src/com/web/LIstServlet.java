package com.web;

import com.bean.Course;
import com.bean.CourseItem;
import com.bean.SelectList;
import com.service.CourseService;
import com.service.ListService;
import com.service.serviceimpl.CourseServiceImpl;
import com.service.serviceimpl.ListServiceImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.utils.webUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listServlet")
public class LIstServlet extends BaseServlet{
      private CourseService courseService=new CourseServiceImpl();
      private ListService listService=new ListServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id=webUtils.parseInt(req.getParameter("id"));
        //调用courseservice，通过id查询数据库里面的课程信息
        Course course=courseService.queryCourseById(id);
        //把图书信息转化成选课项
        CourseItem courseItem=new CourseItem(course.getId(),course.getCoursename() , course.getTeacher());
        //把图书信息放到数据库里面
        listService.addCourseItem(courseItem);
        //重定向回到课表页面
        resp.sendRedirect(req.getContextPath()+"/CourseServlet?action=listItem");

    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取课程编号
        int id=webUtils.parseInt(req.getParameter("id"));
        listService.deleteCourceItem(id);
        //获取列表对象
        SelectList selectList= (SelectList) req.getSession().getAttribute("selectList");
        if (selectList!=null){
            selectList.deleteItem(id);
            //            resp.sendRedirect(req.getContextPath()+"/pages/courselist/lsit.jsp");
        }
        resp.sendRedirect(req.getContextPath()+"/listServlet?action=selectlist");

    }
    protected void selectlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //查询到数据库所有选课信息
        List<CourseItem>courseItems=listService.queryCourseItem();
        //把数据保存到request域里面
        req.setAttribute("courseItems", courseItems);
        req.getRequestDispatcher("/pages/courselist/lsit.jsp").forward(req, resp);

    }
}
