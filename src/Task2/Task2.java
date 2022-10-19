package Task2;

import Task1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(final String[] args) throws CheckedException {
        final Product product1 = new Product("Banana", 30, -30);
        final Product product2 = new Product("Apple", 80, 30);
        final Customer customer1 = new Customer("wick",null);
        final List<Check> checks = Stream.of(new Check(new ArrayList<>(), customer1, null)).collect(Collectors.toList());
        customer1.setListCheck(checks);
        final Storage storage1 = new Storage(Stream.of(product1, product2).collect(Collectors.toList()), Stream.of(customer1).collect(Collectors.toList()));

        System.out.println(storage1);
        AddProductsToStorage.oneProduct(storage1, product1);


    }
}
