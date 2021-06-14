package mai;

import ru.mai.LinkedMethods;
import ru.mai.ArrayMethods;
import ru.mai.MapMethods;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
        String selectCollection = input.nextLine();
        final String arraySelect = "ARRAY";
        final String linkedSelect = "LINKED";
        final String mapSelect = "MAP";
        final String endSelect = "END";
        boolean check = true;

        do {
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
        String inputInCollection;
        do {
            check = true;
            switch (selectCollection) {

                case arraySelect:
                    inputInCollection = input.nextLine();
                    array.add(inputInCollection);
                    break;
                case linkedSelect:
                    inputInCollection = input.nextLine();
                    linked.add(inputInCollection);
                    break;
                case mapSelect:
                    String value = input.nextLine();
                    String key = input.nextLine();

                    break;
                case endSelect:
                    check = false;
                    break;

            }
        } while (!check);

//        MapMethods testMap = new MapMethods(2);
//        MapMethods testMap2 = new MapMethods();
//        testMap.put("Маша", 20);
//        testMap.put("Игорь", 17);
//        testMap.put("Вадим", 19);
//        testMap.put("Лена", 18);
//        testMap.put("Андрей", 19);
//        testMap.put("Вика", 17);
//        System.out.println(testMap.size());
//        testMap2.put("Боря", 12);
//        testMap2.put("Люда", 53);
//        testMap2.put("Катя", 0);
//        testMap2.put("Леша", 18);
//        testMap2.put("Таня", 25);
//        testMap2.put("Кузьма", 60);
//        System.out.println(testMap2.isEmpty());
//        testMap2.clear();
//        System.out.println(testMap2.isEmpty());
//        testMap2.put("Боря", 12);
//        testMap2.put("Люда", 53);
//        testMap2.put("Катя", 0);
//        System.out.println(testMap.containsKey("Маша"));
//        System.out.println(testMap.containsKey("Кузьма"));
//        System.out.println(testMap.containsValue(20));
//        System.out.println(testMap.containsValue(100));
//        System.out.println(testMap.get("Маша"));
//        System.out.println(testMap.get("Кузьма"));
//        System.out.println(testMap.remove("Вика"));
//        testMap.putAll(testMap2);
//

//        LinkedMethods testLinked = new LinkedMethods();
//        testLinked.add("Маша");
//        testLinked.add("Паша");
//        testLinked.add("Вера");
//        testLinked.add("Боря");
//        testLinked.add(1, "Игорь");
//        testLinked.add("Паша");
//        LinkedMethods testLinked2 = new LinkedMethods();
//        testLinked2.add("Ваня");
//        testLinked2.add("Таня");
//        System.out.println(testLinked.addAll(1, testLinked2));
//        System.out.println(Arrays.asList(testLinked2.toArray()).toString());
//        System.out.println(testLinked2.set(1, "Люди"));
//        System.out.println(testLinked2.remove(1));
//        System.out.println(testLinked2.contains("Ваня"));
//        System.out.println(testLinked2.isEmpty());
//        testLinked2.clear();
//        System.out.println(testLinked2.isEmpty());
//        System.out.println(testLinked.get(1));
//        System.out.println(testLinked.remove("Маша"));
//        System.out.println(testLinked.indexOf("Паша"));
//        testLinked.add("Катя");
//        LinkedMethods testLinked3 = new LinkedMethods();
//        testLinked3.add("Игорь");
//        testLinked3.add("Катя");
//        System.out.println(testLinked.containsAll(testLinked3));
//        testLinked.add("Петя");
//        testLinked.add("Женя");


//        ArrayMethods testArray = new ArrayMethods();
//        testArray.add("Маша");
//        testArray.add("Паша");
//        testArray.add(1, "Игорь");
//        testArray.add("Паша");
//        ArrayMethods testArray2 = new ArrayMethods(2);
//        testArray2.add("Ваня");
//        testArray2.add("Таня");
//        System.out.println(testArray.addAll(1, testArray2));
//        System.out.println(Arrays.asList(testArray2.toArray()).toString());
//        System.out.println(testArray2.set(1, "Люди"));
//        System.out.println(testArray2.remove(1));
//        System.out.println(testArray2.contains("Ваня"));
//        System.out.println(testArray2.isEmpty());
//        testArray2.clear();
//        System.out.println(testArray2.isEmpty());
//        System.out.println(testArray.get(1));
//        System.out.println(testArray.remove("Маша"));
//        System.out.println(testArray.indexOf("Паша"));
//        testArray.add("Катя");
//        ArrayMethods testArray3 = new ArrayMethods(2);
//        testArray3.add("Игорь");
//        testArray3.add("Катя");
//        System.out.println(testArray.containsAll(testArray3));
//        testArray.add("Петя");
//        testArray.add("Женя");




    }
}
