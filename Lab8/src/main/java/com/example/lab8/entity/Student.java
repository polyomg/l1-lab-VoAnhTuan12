package com.example.lab8.entity;

public class Student {
    private String name;
    private String email;
    private double marks;
    private String major;

    public Student(String name, String email, double marks, String major) {
        this.name = name;
        this.email = email;
        this.marks = marks;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        if (marks < 5) return "Trượt";
        if (marks < 6.5) return "Trung bình";
        if (marks < 7.5) return "Khá";
        if (marks < 9) return "Giỏi";
        return "Xuất sắc";
    }

    public boolean isMale() {
        return this.name.endsWith(" (Nam)");
    }
}
