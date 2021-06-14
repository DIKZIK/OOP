import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final int numberOfAnimals = 3;
        Animal[] animals = new Animal[numberOfAnimals];
        animals[0] = new Cat("Мурка: ", "питается рыбой ", "живет на печке ", "длинные усы ", "острые когти ");
        animals[1] = new Dog("Шарик: ", "питается всем ", "живет в будке ", "острые клыки ", "любящий взгляд ");
        animals[2] = new Horse("Клювокрыл: ", "ест сено ", "живет в сарае ", "подкованная ", "длинная, коричневая ");
        Vet goToVeterinar = new Vet();

        for (int i = 0; i < numberOfAnimals; ++i) {

            goToVeterinar.treatAnimal(animals[i]);
            System.out.println();
        }
    }
}