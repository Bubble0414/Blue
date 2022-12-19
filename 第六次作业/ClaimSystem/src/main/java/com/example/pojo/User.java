package com.example.pojo;

import lombok.Data;

@Data
public class User {
    private String student_no;
    private String institute;
    private String grade;
    private String class_;
    private String name;
    private String password;
    private String phoneNumber;

    public User(String student_no, String password) {
        this.student_no = student_no;
        this.password = password;

    }

    public User(String student_no, String institute, String grade, String class_, String name, String password, String phoneNumber) {
        this.student_no = student_no;
        this.institute = institute;
        this.grade = grade;
        this.class_ = class_;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User(String username, String password, String phoneNumber) {
        this.student_no = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(String student_no, String institute, String grade, String class_, String name) {
        this.student_no = student_no;
        this.institute = institute;
        this.grade = grade;
        this.class_ = class_;
        this.name = name;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

