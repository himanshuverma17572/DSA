package com.test;

public class Student {

    public Student() {
    }

    public Student(String name, String college) {
        this.name = name;
        this.college = college;
    }

    private String name;
    private String college;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", college='" + college + '\'' +
                '}';
    }
}
