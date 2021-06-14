public class Feeder {

    public void feed(Animals animal) {
        System.out.println("The"+animal.getName()+" cat is fed");
    }

    public void feed(Cow cow){
        System.out.println("The Cow is fed");
    }
}