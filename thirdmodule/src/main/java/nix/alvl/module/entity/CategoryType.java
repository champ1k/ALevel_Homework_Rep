package nix.alvl.module.entity;

import javax.persistence.*;

@Entity
@Table(name = "category_type")
public class CategoryType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type;


    @Column(name = "typename")
    private String name;


    @ManyToOne
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryType() {

    }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
