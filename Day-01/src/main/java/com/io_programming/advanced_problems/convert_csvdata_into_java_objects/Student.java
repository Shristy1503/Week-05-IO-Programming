package com.io_programming.advanced_problems.convert_csvdata_into_java_objects;

public class Student {
    private String id;
    private String name;
    private int age;
    private int marks;
    //constructor
    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}
