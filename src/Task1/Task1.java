package Task1;

import Task3.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(final String[] args) {
        final Product product1 = new Product("Banana", 30, 20);
        final Product product2 = new Product("Apple", 80, 30);
        final Customer customer1 = new Customer("wick", null);
        final List<Check> checks = Stream.of(new Check(new ArrayList<>(), customer1, null)).
                collect(Collectors.toList());
        customer1.setListCheck(checks);
        final Storage storage1 = new Storage(Stream.of(product1, product2).
                collect(Collectors.toList()), Stream.of(customer1).collect(Collectors.toList()));
        final Seller seller1 = new Seller("max", storage1);

        final Service service = new Service(storage1, Stream.of(customer1).collect(Collectors.toList()), Stream.of(seller1).collect(Collectors.toList()));


        service.sellProduct(customer1,new Product(product1.getName(),product1.getPrice(),5));

        System.out.println(storage1);
        System.out.println(customer1);
        service.sellProduct(customer1,new Product(product2.getName(),product2.getPrice(),5));
        System.out.println(storage1);


    }
}
