import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private Product[] products;

    public Category() {

    }

    public Category(String name, Product[] products) {

        this.products = products;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public Product[] getProducts() {

        return products;
    }
}