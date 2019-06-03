package com.example.sergiorl.scheduleweb;

import java.io.Serializable;

public class Assignatures implements Serializable{
    private String assignature;
    private String classroom;
    private int initHour;
    private int endHour;
    private String teacher;
    private int day;

    public Assignatures(String assignature, String classroom, int initHour, int endHour, String teacher, int day){
        this.assignature = assignature;
        this.classroom = classroom;
        this.initHour = initHour;
        this.endHour = endHour;
        this.teacher = teacher;
        this.day = day;
    }

    public String getAssignature() {
        return assignature;
    }
    public String getClassroom() {
        return classroom;
    }
    public int getInitHour() {
        return initHour;
    }
    public int getEndHour() {
        return endHour;
    }
    public String getTeacher() {
        return teacher;
    }
    public int getDay() {
        return day;
    }
    public void setAssignature(String assignature) {
        this.assignature = assignature;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
    public void setInitHour(int initHour) {
        this.initHour = initHour;
    }
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public void setDay(int day) {
        this.day = day;
    }
}
