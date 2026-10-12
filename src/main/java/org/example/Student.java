package org.example;

import java.util.Scanner;

public class Student {
    Scanner sc = new Scanner(System.in);
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private String id;
    private String name;
    private double gpa;
    public Student(){}
    public Student( String id, String name,double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }


    @Override
    public String toString()
    {
        return id + " " + name + " " + gpa;
    }
}
