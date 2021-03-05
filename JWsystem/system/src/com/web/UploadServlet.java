package com.web;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hamcrest.core.Is;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //判断请求是否为multipart请求
        if (!ServletFileUpload.isMultipartContent(req)){
            throw new RuntimeException("当前请求不支持上传文件");
        }

        //创建一个FIleitem工厂
        DiskFileItemFactory factory=new DiskFileItemFactory();

        //设置临时文件，当上传的文件大于设定值的时候，上传文件会先保存在临时文件中，否在就直接写到内容里面
        factory.setSizeThreshold(1024*1024*2);
        String tempPath=this.getServletContext().getRealPath("/temp");
        File temp=new File(tempPath);
        factory.setRepository(temp);
        //创建文件上传核心组件
        ServletFileUpload upload=new ServletFileUpload(factory);
        //设置item的头部编码，防止文件中文名乱码
        upload.setHeaderEncoding("UTF-8");
        //解析请求,获取所有的item
        try {
            List<FileItem>items=upload.parseRequest(req);
            //遍历item
            for (FileItem item:items){
                if (item.isFormField()){
                    //如果item是普通表单数据
                    String fieldName=item.getFieldName();//获取表单的名称
                    String fieldValue=item.getString("UTF-8");//获取表单的值
                    System.out.println(fieldName+"="+fieldValue);
                }else {
                    //当item为文件表单时
                    String fileName=item.getName();//获取上传文件的原始名称
                    req.getSession().setAttribute("filename", fileName);
                    //防止文件同名
                    fileName=System.currentTimeMillis()+fileName;
                    //获取输入流，其中有上传文件的内容
                    InputStream inputStream=item.getInputStream();
                    //获取文件保存在服务器的路径
                    String path=this.getServletContext().getRealPath("/WEB-INF/resource");
                    //创建目标文件，用来保存
                    File descFile=new File(path,fileName);
                    //创建文件输出流
                    OutputStream outputStream=new FileOutputStream(descFile);
                    //把输入流中的数据写到输出流中
                    //定义长度，-1表示最后一个
                    int len=-1;
                    //定义一个数组，相对于缓存
                    byte[] buffer=new byte[1024];

                    while ((len=inputStream.read(buffer))!=-1){
                        outputStream.write(buffer,0, len);
                    }
                    //关闭流
                    outputStream.close();
                    inputStream.close();
                    //删除临时文件
                    item.delete();

                    req.getRequestDispatcher("pages/file/Upload.jsp").forward(req,resp);
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
