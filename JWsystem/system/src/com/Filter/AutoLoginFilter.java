package com.Filter;

import com.bean.User;
import com.dao.UserDao;
import com.dao.daoimpl.UserDaoImpl;
import com.service.UserService;
import com.service.serviceimpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/")
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest Request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url=Request.getContextPath();
        if (url.contains("/login")){
            filterChain.doFilter(Request, response);
        }
        //获取设置的session值
        User loginUser = (User) Request.getSession().getAttribute("loginUser");
        //如果已经有值，说明已经登录了，放行
        if (loginUser!=null){
            filterChain.doFilter(Request, response);
        }else {
            //从cookie中获取账号密码auto_login
            Cookie []cookies=Request.getCookies();
            String autologin=null;
            for (int i=0;i<cookies.length;i++){
                if ("auto_login".equals(cookies[i].getName())){
                    autologin=cookies[i].getValue();
                    break;
                }
            }
            if (autologin==null){
                filterChain.doFilter(Request, response);
            }else {
                String [] parts=autologin.split("-");
                String name=parts[0];
                String password=parts[1];
                System.out.println(name+password);
                UserService userService = new UserServiceImpl();
               boolean is=userService.existUser(name, password);
               if (is){
                   User user=new User();
                   user.setUsername(name);
                   user.setPassword(password);
                   Request.getSession().setAttribute("loginUser",user);
                   filterChain.doFilter(Request,response);
               }else {
                   filterChain.doFilter(Request,response);
               }


            }

        }
    }

    @Override
    public void destroy() {

    }
}
