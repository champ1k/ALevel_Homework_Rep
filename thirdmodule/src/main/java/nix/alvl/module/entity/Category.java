package nix.alvl.module.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_category;

    @OneToMany
    private List<CategoryType> categoryTypes = new ArrayList<>();

    @ManyToOne
    private Operation operation;

    public Category() {

    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public List<CategoryType> getCategoryTypes() {
        return categoryTypes;
    }

    public void setCategoryTypes(List<CategoryType> categoryTypes) {
        this.categoryTypes = categoryTypes;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
