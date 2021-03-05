package com.Listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//不用配置地址
@WebListener
/**
 * 在线人数统计
 */
public class CountOnlineListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext=se.getSession().getServletContext();
        Integer onlineCount= (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount==null){
            onlineCount=1;
        }else {
            int count=onlineCount.intValue();
            onlineCount=++count;
        }
        servletContext.setAttribute("onlineCount", onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        ServletContext servletContext = se.getSession().getServletContext();

        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = 0;
        } else {
            int count = onlineCount.intValue();
            onlineCount = --count;
        }
        servletContext.setAttribute("onlineCount", onlineCount);
    }


}
