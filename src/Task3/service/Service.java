package Task3.service;

import Task1.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Service {
    final private Storage storage;
    final private List<Customer> customerList;
    final private List<Seller> sellerList;

    public Service(final Storage storage, final List<Customer> customerList, final List<Seller> sellerList) {
        this.storage = storage;
        this.customerList = customerList;
        this.sellerList = sellerList;
    }

    public Storage getStorage() {
        return storage;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Seller> getSellerList() {
        return sellerList;
    }

    public void addProduct(final Product product) {
        storage.getProductList().add(product);
    }

    public Product findProduct(final Product customerProduct) {
        for (final Product product : storage.getProductList()) {
            if (product.getName().equals(customerProduct.getName())) {
                return product;
            }
        }
        System.out.println("We can't find this product");
        return null;
    }

    public void sellProduct(final Customer customer, final Product product) {

        final Product storageProduct = findProduct(product);
        if (storageProduct.getAmount() <= product.getAmount()) {
            System.out.println("We don't have so much");
        } else {
            storage.getProductList()
                    .stream()
                    .filter(e -> e.equals(product))
                    .forEach(a -> a.setAmount(a.getAmount() - product.getAmount()));

        }
        customer.getListCheck()
                .add(new Check(Stream.of(product).collect(Collectors.toList()),
                        customer, LocalDate.now()));
    }

    public double averagePrice() {

        return storage.getProductList().stream().collect(Collectors.averagingInt(Product::getPrice));
    }

    public void sortByName() {
        storage.getProductList().sort(Comparator.comparing(Product::getName));
    }

    public void sortByAmount() {
        storage.getProductList().sort(Comparator.comparing(Product::getAmount).reversed());
    }

    public void sortByPrice() {
        storage.getProductList().sort(Comparator.comparing(Product::getPrice));
    }

    public int spendsOfCustomerPerTime(final Customer customer, final LocalDate time) {
        return customer.getListCheck().stream()
                .filter(e -> e.getLocalDate().equals(time)).
                mapToInt(temp -> temp.getProducts().stream().
                        mapToInt(Product::getPrice).
                        sum() * temp.getProducts().
                        stream().
                        mapToInt(Product::getAmount).sum()).sum();

    }

    public List<Product> allProductsOfCustomer(final Customer customer) {
        customerList.stream().filter(e -> e.equals(customer)).findFirst().orElseThrow();
        final List<Product> products = new ArrayList<>();
        customer.getListCheck().forEach(e -> products.addAll(e.getProducts()));

        final Map<Integer, List<Product>> productListMap = products.
                stream().collect(Collectors.groupingBy(e -> e.hashCode()));
        final Map<Integer, Integer> map = productListMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()
                        .stream().mapToInt(Product::getAmount).sum()));

        return products.stream()
                .map(e -> new Product(e.getName(), e.getPrice(), map.get(e.hashCode())))
                .distinct()
                .collect(Collectors.toList());
    }

    public Product mostPopularProduct() {
        final List<Product> prod = new ArrayList<>();
        customerList.forEach(e -> {
            final List<Product> newProd = new ArrayList<>();
            e.getListCheck().forEach(check -> newProd.addAll(check.getProducts()));
            prod.addAll(newProd);
        });

        final Map<Integer, List<Product>> productListMap = prod.
                stream().collect(Collectors.groupingBy(e -> e.hashCode()));
        final Map<Integer, Integer> map = productListMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()
                        .stream().mapToInt(Product::getAmount).sum()));

        final List<Product> prod1 = prod.stream()
                .map(e -> new Product(e.getName(), e.getPrice(), map.get(e.hashCode())))
                .distinct()
                .collect(Collectors.toList());

        return prod1.stream().max(Comparator.comparingInt(p -> p.getAmount())).orElse(null);
    }

    private int revenuePerCheck(final Check check) {
        return check.getProducts().stream().mapToInt(e -> e.getPrice() * e.getAmount()).sum();
    }

    public int highestRevenue() {

        final List<Check> checks = new ArrayList<>();
        customerList.forEach(e -> checks.addAll(e.getListCheck()));
        return checks.stream().collect(Collectors.groupingBy(Check::getLocalDate))
                .entrySet().stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey, e -> e.getValue()
                                .stream().mapToInt(this::revenuePerCheck)
                                .sum())).entrySet().stream()
                .max(Map.Entry.comparingByKey()).get().getValue();


    }
}
