package Task1;

import java.util.List;

public class Storage {

    private List<Product> productList;
    private List<Customer> customerList;

    public Storage(final List<Product> productList, final List<Customer> customerList) {
        this.productList = productList;
        this.customerList = customerList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(final List<Product> productList) {
        this.productList = productList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(final List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "productList=" + productList +
                ", customerList=" + customerList +
                '}';
    }
}
