package com.alvl.nix.homework.lesson13.group;

public class Group {
    private int groupNumber;
    private String groupName;
    private Student[] students;

    Group(int groupNumber, String groupName) {
        this.groupNumber = groupNumber;
        this.groupName = groupName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    void getContractStudents() {
        Student[] contractStudents;

        for (int i = 0; i < students.length; i++) {
            if (students[i] instanceof ContractStudent) {
                System.out.println(students[i].toString());
            }
        }
    }

}
