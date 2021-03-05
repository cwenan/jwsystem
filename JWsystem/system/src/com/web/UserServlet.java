package com.web;

import com.bean.User;
import com.google.gson.Gson;
import com.mysql.cj.Session;
import com.service.UserService;
import com.service.serviceimpl.UserServiceImpl;
import com.sun.org.apache.bcel.internal.generic.GOTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    String message = null;

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
        String name = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        HttpSession session = req.getSession();
        //验证用户名和密码
        User loginUser = userService.login(new User(null, name, password));
        if (loginUser == null) {
            message = "用户名或密码错误，请重新登录";
            session.setAttribute("message", message);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("username", name);
            //获取autologin的值,判断是否点击自动登录
            String autologin = req.getParameter("autologin");
            System.out.println(autologin);
            if ("auto_login".equals(autologin) && autologin != null) {
                //创建cookie和设置时间
                Cookie cookie = new Cookie("auto_login", name + "-" + password);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                /**
                 * 设置cookie有效路径
                 *有效路径指的是 cookie 的有效路径保存在哪里，那么浏览器在有效路径下访问服务器时就会带着 cookie 信息
                 * 否则不带 cookie 信息。
                 * 设置全局路径。
                 */
                cookie.setPath("request.getContextPath()");
                resp.addCookie(cookie);
                req.getSession().setAttribute("loginUser", loginUser);
            }

            if ("admin".equals(name)&&"admin".equals(password)){
                resp.sendRedirect(req.getContextPath() + "/pages/user/admin.jsp");
            }
            resp.sendRedirect(req.getContextPath() + "/pages/user/login_success.jsp");
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                System.out.println("用户名已存在");
                req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            } else {
                userService.regisitUser(new User(null, username, password));
                req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void existUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //设置格式
        resp.setContentType("text/xml;charset=UTF-8");
        resp.setHeader("Cache-Control", "no-cache");
        //获取username
        String username=req.getParameter("username");
        //调用exist方法
        boolean existUsername = userService.existUsername(username);
        String message="用户名有效";
        PrintWriter out=resp.getWriter();
        if (!existUsername){
            message="用户名无效,请重新检查";
        }
        out.println("<response>");
        out.println("<message >"+message+"</message>");
        out.println("</response>");




//       Gson gson=new Gson();
//        Map<String,String> resultMap=new HashMap<>();
//        if (existUsername){
//            resultMap.put("message", message);
//        }
//        String json=gson.toJson(resultMap);
////        resp.getWriter().write(json);
//
//        }
    }
}