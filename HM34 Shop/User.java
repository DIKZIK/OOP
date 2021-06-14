public class User {

    private String log;
    private String pass;
    private Basket userBasket = new Basket();

    public User(String log, String pass, Basket userBasket) {

        this.log = log;
        this.pass = pass;
        this.userBasket = userBasket;
    }

    public void systemReport() {

        System.out.println("Account is created, have a nice shopping");
    }

    public Basket getUserBasket() {

        return userBasket;
    }

    public String getLog() {

        return log;
    }

    public String getPass() {

        return pass;
    }
}