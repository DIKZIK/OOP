package mai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String selectCollection;
        final String arraySelect = "ARRAY";
        final String linkedSelect = "LINKED";
        final String mapSelect = "MAP";
        final int EMPTY = 0;
        boolean check = true;
        do {
            selectCollection = input.nextLine();
            check = true;
            if (selectCollection.matches("^ARRAY$|^LINKED$|^MAP$")) {
                check = false;
            } else {
                System.out.println("Incorrect input");
            }
        } while (check);
        ArrayMethods array = new ArrayMethods();
        LinkedMethods linked = new LinkedMethods();
        MapMethods map = new MapMethods();
        String inputInColletction;
        do {
            inputInColletction = input.nextLine();
            check = true;
            if (inputInColletction.equals("END")) {
                check = false;
                break;
            }
            switch (selectCollection) {
                case arraySelect:
                    array.add(inputInColletction);
                    break;
                case linkedSelect:
                    linked.add(inputInColletction);
                    break;
                case mapSelect:
                    boolean secCheck;
                    int value = EMPTY;
                    do {
                        System.out.print("input value: ");
                        if (input.hasNextInt()) {
                            value = input.nextInt();
                            secCheck = true;
                            if (value <= 0) {
                                System.out.println("the value must be greater than 0");
                                secCheck = false;
                            }
                        } else {
                            input.nextLine();
                            System.out.println("You input not an integer value.");
                            secCheck = false;
                        }
                    } while (!secCheck);
                    input.nextLine();
                    map.put(inputInColletction, value);
                    break;
            }
        } while (check);
        switch (selectCollection) {
            case arraySelect:
                System.out.println(array.size());
                break;
            case linkedSelect:
                System.out.println(linked.size());
                break;
            case mapSelect:
                System.out.println(map.size());
                break;
        }
        System.out.println("show all elements of the collection?");
        String choice = input.nextLine();
        if (choice.equals("YES")) {
            switch (selectCollection) {
                case arraySelect:
                    for (String element : array.toArray()) {
                        System.out.println(element);
                    }
                    break;
                case linkedSelect:
                    for (String element : linked.toArray()) {

                        System.out.println(element);
                    }
                    break;
                case mapSelect:
                    for (MapMethods.Node node : map.nodeBasket) {
                        if (node != null) {
                            System.out.println(node.key + " -> " + node.value);
                        }
                    }
                    break;
            }
        }
        long time = EMPTY;
        System.out.println("Do you want get element?");
        if (input.nextLine().equals("YES")) {

            int index = 0;
            time = System.currentTimeMillis();

            switch (selectCollection) {

                case arraySelect:
                    check = false;
                    do {

                        System.out.print("Enter index: ");
                        if (input.hasNextInt()) {
                            index = input.nextInt();
                            check = true;

                            if (index <= 0) {

                                System.out.println("Enter index > 0.");
                                check = false;
                            }
                        } else {

                            input.nextLine();
                            System.out.println("Not an integer.");
                            check = false;
                        }
                    } while (!check);
                    System.out.println(array.get(index));
                    break;
                case linkedSelect:
                    do {
                        System.out.print("Enter index: ");
                        if (input.hasNextInt()) {
                            index = input.nextInt();
                            check = true;
                            if (index <= 0) {

                                System.out.println("Enter index > 0.");
                                check = false;
                            }
                        } else {

                            input.nextLine();
                            System.out.println("Not an integer.");
                            check = false;
                        }
                    } while (!check);
                    System.out.println(linked.get(index));
                    break;
                case mapSelect:
                    System.out.println("Enter key: ");
                    String key = input.nextLine();
                    System.out.println(map.get(key));
                    break;
            }
        }
        if (time != 0) {
            double currentTime = System.currentTimeMillis();
            System.out.println("Поиск по элементам занял " + (currentTime - time) + " миллисекунд.");
        }
    }
}
