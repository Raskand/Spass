package com.apps.spass.model;

public class Inspection {

    String name,no,lessonID,dateTime,id;

    public Inspection(){

    }

    public Inspection(String name, String no, String lessonID, String dateTime, String id) {
        this.name = name;
        this.no = no;
        this.lessonID = lessonID;
        this.dateTime = dateTime;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLessonID() {
        return lessonID;
    }

    public void setLessonID(String lessonID) {
        this.lessonID = lessonID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
