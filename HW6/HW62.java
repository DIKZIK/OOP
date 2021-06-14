//package com.company;

/*
Программа считывает и сохраняет в коллекцию положительные числа (целые и вещественные) до тех пор,
пока пользователь не введёт число 0. Ноль при этом никуда не сохраняется и не используется для дальнейших вычислений.
Необходимо найти среднее значение из всех введённых чисел и вывести все числа, что больше найденному среднему значению,
в порядке возрастания без повторов одинаковых чисел.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class HW62 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Double> numbersArray = new ArrayList<>();
        boolean check = true;

        System.out.println("Enter your number, to exit the program press 0");
        do {

            double buffer = 0;
            if (input.hasNextDouble()) {

                buffer = input.nextDouble();
                if (buffer > 0) {

                    check = true;
                    numbersArray.add(buffer);
                } else if (buffer == 0) {

                    input.nextLine();
                    check = false;
                } else {

                    check = true;
                    input.nextLine();
                    System.out.println("You entered incorrect data, try again");
                }
            }
        } while (check);

        if (!numbersArray.isEmpty()) {

            double sumOfNumbers = 0;
            double averageOfArray = 0;
            TreeSet<Double> sortedNumbers = new TreeSet<>();

            for (int i = 0; i < numbersArray.size(); ++i) {

                sumOfNumbers += numbersArray.get(i);
            }

            averageOfArray = sumOfNumbers / numbersArray.size();

            for (int i = 0; i < numbersArray.size(); ++i) {
                if (numbersArray.get(i) > averageOfArray) {

                    sortedNumbers.add(numbersArray.get(i));
                }
            }

            for (Double result : sortedNumbers) {

                System.out.println(result);
            }
        } else {

            System.out.println("Collection has no numbers");
        }

    }
}
