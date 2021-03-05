package com.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SelectList {
    //列表和总数,能使用局部变量就不用全局变量
//    private Integer totalCount;

    private Map<Integer,CourseItem> items=new LinkedHashMap<Integer, CourseItem>();

    /**
     * 添加课程
     * @param courseItem
     */
    public void  addItem(CourseItem courseItem){
        items.put(courseItem.getId(),courseItem);
    }

    /**
     * 删除课程
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空课程
     */
    public void clear(){
        items.clear();
    }



    public Integer getTotalCount() {
        //获取总数量,使用size()方法
        int totalCount=0;
        totalCount=items.size();
        return totalCount;
    }



    public Map<Integer, CourseItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CourseItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SelectList{" +
                "totalCount=" + getTotalCount() +
                ", items=" + items +
                '}';
    }
}
