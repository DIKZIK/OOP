//package com.company;

/*
В консоли вводятся количество значений – N, и N значений соответственно в одном из форматов
(для примера значения 3 с весом 2): «x: 3; p: 2», «p: 2; x: 3» или «x: 3» (вес по умолчанию равен значению 1, т.е.
эквивалентно записям «x: 3; p: 1» и «p: 1; x: 3»). Оба значения могут быть как целыми числами, так и вещественными.
В случае несоответствия формату, просить пользователя ввести число ещё раз.
Необходимо вычислить и напечатать среднее арифметическое взвешенное из введённых чисел.
Округлить полученное значение до трёх знаков после запятой.
 */

import java.util.Scanner;

public class HW54 {

    public static void main(String[] args) {

        final int numberPosition = 3;
        Scanner input = new Scanner(System.in);
        boolean check = true;
        int amountOfNumbers = 0;
        String regular = "^(x: -?\\d+(\\.\\d+)?; p: \\d+(\\.\\d+)?)|(p: \\d+(\\.\\d+)?; x: -?\\d+(\\.\\d+)?)|(x: -?\\d+(\\.\\d+)?)$";

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

        double numeratorPX = 0;
        double sumP = 0;
        input.nextLine();

        for (int i = 0; i < amountOfNumbers; ++i) {

            String valueString;
            do {

                valueString = input.nextLine();
                System.out.println("Enter x and p value");

                if (!(valueString.matches(regular))) {

                    input.nextLine();
                    System.out.println("Invalid input, please try again");
                }
            } while (!valueString.matches(regular));

            String[] parsNumber = valueString.split(";");

            double xValue = 0;
            double pValue = 0;

            if (parsNumber[0].startsWith("x")) {

                xValue = Double.parseDouble(parsNumber[0].substring(numberPosition));
                if (parsNumber.length == 1) {
                    pValue = 1;
                } else {
                    pValue = Double.parseDouble(parsNumber[1].substring(numberPosition));
                }
            } else if (parsNumber[0].startsWith("p")) {

                pValue = Double.parseDouble(parsNumber[0].substring(numberPosition));
                xValue = Double.parseDouble(parsNumber[1].substring(numberPosition));
            }

            sumP += pValue;
            numeratorPX += (xValue * pValue);
        }

        double result = numeratorPX / sumP;

        System.out.println(String.format("%.3f", result));
    }
}
