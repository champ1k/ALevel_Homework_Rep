package nix.alvl.module.model;

import java.util.List;
import java.util.Objects;

public class User {
    private int index;
    private String name;
    private int age;
    private String phonenumber;
    private String email;
    private List<Bill> bills;

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public User(int index, String name, int age, String phonenumber, String email, List<Bill> bills) {
        this.index = index;
        this.name = name;
        this.age = age;
        this.phonenumber = phonenumber;
        this.email = email;
        this.bills = bills;
    }

    public User() {
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return index == user.index &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(phonenumber, user.phonenumber) &&
                Objects.equals(email, user.email) &&
                Objects.equals(bills, user.bills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name, age, phonenumber, email, bills);
    }

    @Override
    public String toString() {
        return "User{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", bills=" + bills +
                '}';
    }
}
