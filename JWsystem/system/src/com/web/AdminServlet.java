package com.web;

import com.bean.User;
import com.dao.UserDao;
import com.dao.daoimpl.UserDaoImpl;
import com.service.CourseService;
import com.service.UserService;
import com.service.serviceimpl.UserServiceImpl;
import com.utils.webUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
@WebServlet("/admin")
public class AdminServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    private UserService userService=new UserServiceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
//        String username=req.getParameter("username");
//        String password=req.getParameter("password");
        User user=new User();
        BeanUtils.populate(user, req.getParameterMap());
        userService.regisitUser(user);
        resp.sendRedirect(req.getContextPath()+"/admin?action=listUser");
    }
    protected void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //查询除了管理员以外所有用户信息
        List<User>users=userService.queryUsers();
        //保存到request域里面
        req.setAttribute("users", users);
        req.getSession().setAttribute("users", users);
//        req.getRequestDispatcher("/pages/user/usermanage.jsp").forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/pages/usermanage/usermanage.jsp");
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        int id=webUtils.parseInt(req.getParameter("id"));
        userService.deleteUserById(id);
        resp.sendRedirect(req.getContextPath()+"/admin?action=listUser");
    }
}
