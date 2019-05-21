package com.apps.spass.model;

public class Lesson {

    String title,teacher,id,size,itemID,className;

    public Lesson(){

    }

    public Lesson(String title, String teacher, String id, String size, String itemID,String className) {
        this.title = title;
        this.teacher = teacher;
        this.id = id;
        this.size = size;
        this.itemID = itemID;
        this.className=className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
}
