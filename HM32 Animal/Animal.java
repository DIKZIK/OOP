public class Animal {

    private String name;
    private String food;
    private String location;

    public Animal(String name, String food, String location) {

        this.name = name;
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {

        System.out.println("the animal heard a noise");
    }

    public void eat() {

        System.out.println("animal eats");
    }

    public void sleep() {

        System.out.println("animal sleeps");

    }

    public String getFood() {

        return food;
    }

    public String getLocation() {

        return location;
    }

    public String getName() {

        return name;
    }
}