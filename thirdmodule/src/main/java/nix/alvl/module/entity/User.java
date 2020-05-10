package nix.alvl.module.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {


    public User() {
    }

    public User(String name, Long age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.userBills = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Bill> userBills = new ArrayList<Bill>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bill> getUserBills() {
        return userBills;
    }

    public void setUserBills(List<Bill> userBills) {
        this.userBills = userBills;
    }


}
