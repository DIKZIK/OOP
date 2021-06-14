import java.util.ArrayList;
import java.util.List;

public class Basket {

    private Product[] products;

    public void backetProduct(Product[] product) {

        this.products = product;
    }

    public Product[] getProducts() {

        return products;
    }
}