package nix.alvl.module.model;

import java.util.List;
import java.util.Objects;

public class Bill {
    private int index;

    private List<Operation> operations;

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "index=" + index +
                ", operations=" + operations +
                '}';
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return index == bill.index &&
                Objects.equals(operations, bill.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, operations);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public int getIndex() {
        return index;
    }

    public Bill(int index, List<Operation> operations) {
        this.index = index;
        this.operations = operations;
    }
}
