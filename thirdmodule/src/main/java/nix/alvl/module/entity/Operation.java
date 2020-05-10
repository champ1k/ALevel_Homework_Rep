package nix.alvl.module.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "operation")
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_operation;

    @OneToMany
    private List<Category> id_category = new ArrayList<>();

    @Column(name = "date")
    private Instant date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    public Bill bill;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Operation() {

    }

    public Integer getId_operation() {
        return id_operation;
    }

    public void setId_operation(Integer id_operation) {
        this.id_operation = id_operation;
    }

    public List<Category> getId_category() {
        return id_category;
    }

    public void setId_category(List<Category> id_category) {
        this.id_category = id_category;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
