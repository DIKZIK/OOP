package mai;

import mai.interfaces.Array;
import mai.interfaces.Linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedMethods testLinked = new LinkedMethods();
        testLinked.add("Маша");
        testLinked.add("Паша");
        testLinked.add("Вера");
        testLinked.add("Боря");
        testLinked.add(1, "Игорь");
        testLinked.add("Паша");
        LinkedMethods testLinked2 = new LinkedMethods();
        testLinked2.add("Ваня");
        testLinked2.add("Таня");
        System.out.println(testLinked.addAll(1, testLinked2));
        System.out.println(Arrays.asList(testLinked2.toArray()).toString());
        System.out.println(testLinked2.set(1, "Люди"));
        System.out.println(testLinked2.remove(1));
        System.out.println(testLinked2.contains("Ваня"));
        System.out.println(testLinked2.isEmpty());
        testLinked2.clear();
        System.out.println(testLinked2.isEmpty());
        System.out.println(testLinked.get(1));
        System.out.println(testLinked.remove("Маша"));
        System.out.println(testLinked.indexOf("Паша"));
        testLinked.add("Катя");
        LinkedMethods testLinked3 = new LinkedMethods();
        testLinked3.add("Игорь");
        testLinked3.add("Катя");
        System.out.println(testLinked.containsAll(testLinked3));
        testLinked.add("Петя");
        testLinked.add("Женя");

    }
}
