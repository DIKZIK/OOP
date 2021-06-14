public class Cat extends Animal {

    private String mustache;
    private String claws;
    private String name;

    public Cat(String name, String food, String location, String mustache, String claws) {

        super(name, food, location);
        this.mustache = mustache;
        this.claws = claws;
    }


    @Override
    public void makeNoise() {
        System.out.println(getName() + "heard a noise");
    }

    @Override
    public void eat() {
        System.out.println(getName() + "eats");
    }

    public String getClaws() {

        return claws;
    }

    public String getMustache() {

        return mustache;
    }

    public String getName() {

        return name;
    }
}