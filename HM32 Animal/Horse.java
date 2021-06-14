public class Horse extends Animal {

    private String hooves;
    private String mane;

    public Horse(String name, String food, String location, String mane, String hooves) {

        super(name, food, location);
        this.hooves = hooves;
        this.mane = mane;
    }

    @Override
    public void makeNoise() {

        System.out.println(getName() + "heard a noise");
    }

    @Override
    public void eat() {

        System.out.println(getName() + "eats");
    }

    public String getHooves() {

        return hooves;
    }

    public String getMane() {

        return mane;
    }
}