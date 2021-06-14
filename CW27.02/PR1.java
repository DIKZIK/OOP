public class PR1 {
    public static void main(String[] args) {
       /* Box emptyBox = new Box();
        System.out.println("box volume"+emptyBox.getVolume());
        System.out.println(emptyBox);
        System.out.println(emptyBox.toString());


        Box box = new Box(1, 2, 3);
        System.out.println(box.getWidth());
        System.out.println(box.getVolume());

        Container defContainer = new Container();
        System.out.println("Def Container has volume " + defContainer.getVolume());
        Container container = new Container(1, 2, 3, 4);
        System.out.println("container has volume" + container.getVolume());
        System.out.println("container has heigth" + container.getHeigth());
        System.out.println("container has weigth" + container.getWeight());

        Box castBox = new Container();
        double weight = ((Container) castBox).getWeight();
        System.out.println(weight);

        container.print();


        Cat cat = new Cat();
        Dog dog = new Dog();
        Animals[] animals = new Animals[] {cat, dog};
        for(Animals animal : animals){
            animal.voice();
            animal.run();
            animal.walk();
        }

        Cow cow = new Cow();
        Sound[] sounds = new Sound[] {cat, dog, cow};
        for(Sound sound : sounds){
            sound.voice();
            if( sound instanceof Animals){
                ((Animals)sound).run();
            }
            else if (sound instanceof Cow)
                ((Cow) sound).run(); */

        Cat cat = new Cat("Pushok");
        Dog dogMuh = new Dog("Muhtar");
        Dog dogShar = new Dog("Sharik");
        Cow cow = new Cow();
        
        Feeder feeder = new Feeder();
        feeder.feed(cat);
        feeder.feed(dogMuh);
        feeder.feed(dogShar);
        feeder.feed(cow);
        }
    }
