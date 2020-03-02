package com.alvl.nix.homework.lesson13.group;

public class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public void setAge(int age) {
        if(age<=0)
            throw new IllegalArgumentException("Age is negative!");
        this.age = age;
    }

    public void setName(String name) {
        if (name == null || name=="") {
            throw new IllegalArgumentException("Name is empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString()
    {
        return "Student - "+getName()+". Age - "+getAge()+".";
    }
}
