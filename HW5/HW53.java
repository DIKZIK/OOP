//package com.company;

/*
В консоли вводятся количество чисел – N, и N чисел соответственно.
Числа могут быть целыми или вещественными.
В случае некорректного ввода, просить пользователя ввести число ещё раз.
Необходимо вычислить и напечатать среднеквадратическое отклонение из введённых чисел.
Округлить полученное значение до трёх знаков после запятой.
 */

import java.util.Scanner;

public class HW53 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean check = true;
        int amountOfNumbers = 0;
        System.out.println("Enter amount of numbers");
        do {

            if (input.hasNextInt()) {

                amountOfNumbers = input.nextInt();
                check = true;
                if (amountOfNumbers <= 0) {
                    check = false;
                    System.out.println("Enter a number that is great than 0");
                }
            } else {

                check = false;
                System.out.println("Enter an integer value");
                input.nextLine();
            }

        } while (!check);

        double[] number = new double[amountOfNumbers];

        System.out.println("Enter numbers");
        for (int i = 0; i < number.length; ++i) {

            do {

                if (input.hasNextDouble()) {

                    number[i] = input.nextDouble();
                    check = true;

                } else {

                    check = false;
                    System.out.println("You entered not a number");
                    input.nextLine();
                }
            } while (!check);
        }

        double sum = 0;

        for (int i = 0; i < number.length; ++i) {

            sum += number[i];
        }

        double averageValue = (sum / number.length);
        double dispersion = 0;

        for (int i = 0; i < number.length; ++i) {

            dispersion += Math.pow((number[i] - averageValue), 2);
        }

        double result = Math.sqrt(dispersion / number.length);
        System.out.println(String.format("%.3f", result));
    }
}
