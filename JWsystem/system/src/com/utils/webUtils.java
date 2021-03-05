package com.utils;

import com.bean.Course;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class webUtils {
//    public static Course copyParaToBean(Map<String, String[]> req, Object bean) {
//        try {
//            BeanUtils.populate(bean,req.getParameterMap());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 数据转型
     * @param strInt
     * @param
     * @return
     */
    public static int parseInt(String strInt){
        return Integer.parseInt(strInt);
    }
}
