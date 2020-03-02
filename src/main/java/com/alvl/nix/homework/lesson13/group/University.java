package com.alvl.nix.homework.lesson13.group;

public class University {
    public static void main(String[] args) {
        Group groupOne = new Group(1, "First Group");
        Student[] students = {new Student(18, "Alex"), new Student(22, "Bogdan"), new ContractStudent(23, "Nina", 18000)};
        groupOne.setStudents(students);
        groupOne.getContractStudents();
    }
}
