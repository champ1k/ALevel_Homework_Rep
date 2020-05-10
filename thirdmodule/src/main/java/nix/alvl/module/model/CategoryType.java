package nix.alvl.module.model;

import java.util.Objects;

public class CategoryType {

    private int index;

    private String name;

    public CategoryType(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType() {
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryType that = (CategoryType) o;
        return index == that.index &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }

    public String getName() {
        return name;
    }


}
