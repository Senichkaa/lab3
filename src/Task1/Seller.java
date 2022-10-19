package Task1;


import java.time.LocalDate;
import java.util.List;

public class Seller {
    private String name;
    private Storage storage;

    public Seller(final String name, final Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(final Storage storage) {
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    List<Check> getCheck(final Customer customer) {
        return customer.getListCheck();
    }

}
