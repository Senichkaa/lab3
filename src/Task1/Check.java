package Task1;

import java.time.LocalDate;
import java.util.List;

public class Check {
    private List<Product> products;
    private LocalDate localDate;
    private Customer customer;

    public Check(final List<Product> products, final Customer customer, final LocalDate localDate) {
        this.products = products;
        this.localDate = localDate;
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(final LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Check{" +
                "products=" + products +
                ", localDate=" + localDate +
                ", customer=" + customer.getName() +
                '}';
    }

}
