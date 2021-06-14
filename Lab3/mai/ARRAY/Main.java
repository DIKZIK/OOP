package mai;

import mai.interfaces.Array;
import mai.interfaces.Linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayMethods testArray = new ArrayMethods();
        testArray.add("Маша");
        testArray.add("Паша");
        testArray.add(1, "Игорь");
        testArray.add("Паша");
        ArrayMethods testArray2 = new ArrayMethods(2);
        testArray2.add("Ваня");
        testArray2.add("Таня");
        System.out.println(testArray.addAll(1, testArray2));
        System.out.println(Arrays.asList(testArray2.toArray()).toString());
        System.out.println(testArray2.set(1, "Люди"));
        System.out.println(testArray2.remove(1));
        System.out.println(testArray2.contains("Ваня"));
        System.out.println(testArray2.isEmpty());
        testArray2.clear();
        System.out.println(testArray2.isEmpty());
        System.out.println(testArray.get(1));
        System.out.println(testArray.remove("Маша"));
        System.out.println(testArray.indexOf("Паша"));
        testArray.add("Катя");
        ArrayMethods testArray3 = new ArrayMethods(2);
        testArray3.add("Игорь");
        testArray3.add("Катя");
        System.out.println(testArray.containsAll(testArray3));
        testArray.add("Петя");
        testArray.add("Женя");
        System.out.println(testArray.subList(2,3));


    }
}
