package com.bean;

public class CourseItem {
    private Integer id;
    private String name;
    private String teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public CourseItem(Integer id, String name, String teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }


    public CourseItem() {
    }

    @Override
    public String toString() {
        return "CourseItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
