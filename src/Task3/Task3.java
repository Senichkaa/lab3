package Task3;

import Task1.*;
import Task3.service.*;


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(final String[] args) {
        final Product product1 = new Product("Banana", 30, 50);
        final Product product2 = new Product("Apple", 80, 30);
        final Customer customer1 = new Customer("wick", new ArrayList<>());

        final Storage storage1 = new Storage(Stream.of(product1, product2)
                .collect(Collectors.toList()), Stream.of(customer1).collect(Collectors.toList()));
        final Seller seller1 = new Seller("max", storage1);
        final Service service = new Service(storage1, Stream.of(customer1)
                .collect(Collectors.toList()), Stream.of(seller1).collect(Collectors.toList()));

        service.sellProduct(customer1,new Product(product1.getName(),product1.getPrice(),17));
        service.sellProduct(customer1,new Product(product1.getName(),product1.getPrice(),10));
        service.sellProduct(customer1,new Product(product2.getName(),product2.getPrice(),5));
        service.sortByAmount();
        System.out.println("Sorting by amount: " + '\n' + storage1);
        System.out.println("Average price: " + service.averagePrice());
        System.out.println("Spends per day: "+service.spendsOfCustomerPerTime(customer1,LocalDate.now()));
        service.allProductsOfCustomer(customer1).forEach(System.out::println);
        System.out.println("Most popular product: "+service.mostPopularProduct());
        System.out.println("Biggest revenue: "+ service.highestRevenue());



    }
}
