package nix.alvl.module.model;

import java.util.List;
import java.util.Objects;

public class Category {
    private int index;

    private int price;

    private List<CategoryType> types;

    public Category(int index, int price, List<CategoryType> types) {
        this.index = index;
        this.price = price;
        this.types = types;
    }

    public Category() {

    }

    public int getIndex() {
        return index;
    }

    public int getPrice() {
        return price;
    }

    public List<CategoryType> getTypes() {
        return types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return index == category.index &&
                price == category.price &&
                Objects.equals(types, category.types);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTypes(List<CategoryType> types) {
        this.types = types;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, price, types);
    }

    @Override
    public String toString() {
        return "Category{" +
                "index=" + index +
                ", price=" + price +
                ", types=" + types +
                '}';
    }
}
