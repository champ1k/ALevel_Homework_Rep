package nix.alvl.module.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Operation {
    private int index;

    private Timestamp date;

    private List<Category> categories;

    public Operation() {
    }

    private String description;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Operation(int index, Timestamp date, List<Category> categories, String description) {
        this.index = index;
        this.date = date;
        this.categories = categories;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public Timestamp getDate() {
        return date;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return index == operation.index &&
                Objects.equals(date, operation.date) &&
                Objects.equals(categories, operation.categories) &&
                Objects.equals(description, operation.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, date, categories, description);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "index=" + index +
                ", date=" + date +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                '}';
    }
}
