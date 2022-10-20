package Task2;

import Task1.*;

public class AddProductsToStorage {

    public static void oneProduct(final Storage storage, final Product product) throws CheckedException {

        if (validate(product)) {
            storage.getProductList().add(product);
        }
    }

    public static boolean validate(final Product product) throws CheckedException {

        if (product.getName() != null && product.getName().isEmpty()) {
            throw new CheckedException("Wrong name of product");
        }

        if (product.getAmount() <= 0) {
            throw new CheckedException("Wrong amount of product");
        }
        if (product.getPrice() <= 0) {
            throw new CheckedException("Wrong price of product");
        }
        return true;
    }
}
