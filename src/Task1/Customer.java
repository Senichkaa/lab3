package Task1;

import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;

    private List<Check> listCheck;

    public Customer(final String name, final List<Check> listCheck) {
        this.name = name;
        this.listCheck = listCheck;
    }

    public List<Check> getListCheck() {
        return listCheck;
    }

    public void setListCheck(final List<Check> listCheck) {
        this.listCheck = listCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", listCheck=" + listCheck +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(listCheck, customer.listCheck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, listCheck);
    }
}
