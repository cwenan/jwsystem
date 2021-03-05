package com.Listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class CountOnline  implements HttpSessionListener {
//    public void sessionCreated(HttpSessionEvent se) {
//
//        //获取得到Context对象，使用Context域对象保存用户在线的个数
//        ServletContext context = se.getSession().getServletContext();
//
//        //直接判断Context对象是否存在这个域，如果存在就人数+1,如果不存在，那么就将属性设置到Context域中
//        Integer num = (Integer) context.getAttribute("num");
//
//        if (num == null) {
//            context.setAttribute("num", 1);
//        } else {
//            num++;
//            context.setAttribute("num", num);
//        }
//    }
//    public void sessionDestroyed(HttpSessionEvent se) {
//
//        ServletContext context = se.getSession().getServletContext();
//        Integer num = (Integer) se.getSession().getAttribute("num");
//
//        if (num == null) {
//            context.setAttribute("num", 1);
//        } else {
//            num--;
//            context.setAttribute("num", num);
//        }
//    }
}


