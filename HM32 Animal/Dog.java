public class Dog extends Animal {

    private String fangs;
    private String cuteLook;

    public Dog(String name, String food, String location, String fangs, String cuteLook) {

        super(name, food, location);
        this.fangs = fangs;
        this.cuteLook = cuteLook;
    }

    @Override
    public void makeNoise() {

        System.out.println(getName() + "heard a noise");
    }

    @Override
    public void eat() {

        System.out.println(getName() + "eats");
    }

    public String getCuteLook() {

        return cuteLook;
    }

    public String getFangs() {

        return fangs;
    }
}