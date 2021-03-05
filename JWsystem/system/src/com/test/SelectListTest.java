package com.test;

import com.bean.CourseItem;
import com.bean.SelectList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectListTest {

    @Test
    public void addItem() {
        SelectList selectList=new SelectList();
        selectList.addItem(new CourseItem(001,"java入门到放弃", "李老师"));
        selectList.addItem(new CourseItem(78,"mysql删库到跑路", "李老师"));
        System.out.println(selectList);

    }

    @Test
    public void deleteItem() {
        SelectList selectList=new SelectList();
        selectList.addItem(new CourseItem(001,"java入门到放弃", "李老师"));
        selectList.addItem(new CourseItem(78,"mysql删库到跑路", "李老师"));
        selectList.deleteItem(78);
        System.out.println(selectList);
    }

    @Test
    public void clear() {
        SelectList selectList=new SelectList();
        selectList.addItem(new CourseItem(001,"java入门到放弃", "李老师"));
        selectList.addItem(new CourseItem(78,"mysql删库到跑路", "李老师"));
        selectList.addItem(new CourseItem(99, "xiaosiwl","李老师"));
selectList.clear();
        System.out.println(selectList);
    }
}