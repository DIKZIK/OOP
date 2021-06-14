public class Main {

    public static void main(String[] args) {

        Category clothes = new Category();
        Category shoes = new Category();
        Category accessories = new Category();
        Basket userBasket = new Basket();
        User andrey = new User("1234", "56789", userBasket);
        andrey.systemReport();
    }
}