public class Product {

    private String name;
    private double price;
    private float rating;

    public Product(String name, double price, float rating) {

        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {

        return name;
    }

    public double getPrice() {

        return price;
    }

    public float getRating() {

        return rating;
    }
}