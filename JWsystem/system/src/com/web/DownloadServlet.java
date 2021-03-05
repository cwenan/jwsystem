package com.web;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要下载的内容
        String downloadFileName="C程序设计 第五版.pdf";
        //读取要下载的文件内容
        ServletContext servletContext=getServletContext();
        //获取要下载的数据类型
        String mimeType=servletContext.getMimeType("/WEB-INF/resource"+downloadFileName);
        System.out.println(mimeType);
        //在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        /**
         * 告诉客户端收到的数据用于下载使用（使用响应头）
         * Connection-Disposition表示收到的数据怎么处理
         * attachment表示附件，表示下载使用
         * filename=表示指定下载的文件名,文件名可以自己自定义，不受影响。
         */
        if (req.getHeader("User-Agent").contains("Firefox")){
            resp.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+new BASE64Encoder().encode(downloadFileName.getBytes("UTF-8"))+"?=");
        }
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(downloadFileName,"UTF-8"));
        /**
         * /斜杠表示地址为http://ip:port/工程名/,映射到web目录。
         * 获得输入流
         */
        InputStream inputStream=servletContext.getResourceAsStream("/WEB-INF/resource/"+downloadFileName);
        //获取相应的输出流
        OutputStream outputStream=resp.getOutputStream();
        //使用io包里面的内置方法，读取输入流中的全部数据，复制给输出流,返回给客户端
        IOUtils.copy(inputStream,outputStream);

    }
}
