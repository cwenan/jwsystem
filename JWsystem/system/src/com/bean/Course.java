package com.bean;

public class Course {
    private Integer id;
    private String coursename;
    private String teacher;
    private String classes;
    private String place;
    private String time;

    //生成get和set方法


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    //构造方法
    //无参
    public Course() {
    }
    //有参

    public Course(Integer id, String coursename, String teacher, String classes, String place, String time) {
        this.id = id;
        this.coursename = coursename;
        this.teacher = teacher;
        this.classes = classes;
        this.place = place;
        this.time = time;
    }
    //tostring方法

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", teacher='" + teacher + '\'' +
                ", classes='" + classes + '\'' +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
