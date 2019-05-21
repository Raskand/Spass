package com.apps.spass.model;

public class ClassList {

    String className, size,itemID;

    public ClassList(){

    }

    public ClassList(String className, String size,String itemID) {
        this.className = className;
        this.size = size;
        this.itemID=itemID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
