package nix.alvl.module.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill")
public class Bill {


    public Bill(User user, List<Operation> id_operation) {
        this.user = user;
        this.id_operation = id_operation;
    }

    public Bill() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bill;

    @ManyToOne
    private User user;

    @OneToMany
    @Column(name = "id_operation")
    private List<Operation> id_operation = new ArrayList<>();

    public Integer getId_bill() {
        return id_bill;
    }

    public void setId_bill(Integer id_bill) {
        this.id_bill = id_bill;
    }

    public List<Operation> getId_operation() {
        return id_operation;
    }

    public void setId_operation(List<Operation> id_operation) {
        this.id_operation = id_operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
