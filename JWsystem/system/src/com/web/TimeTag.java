package com.web;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TimeTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out=getJspContext().getOut();
        Date date=new Date();
        SimpleDateFormat dataFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        out.println("当前的时间是："+ dataFormat.format(date));
    }
}
