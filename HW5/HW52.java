//package com.company;

import java.util.Scanner;

/*
В консоли вводятся изначальная цена товара на начало месяца с учетом изначального процента инфляции
(целое или вещественное число), изначальный процент инфляции (целое или вещественное число),
количество месяцев – N (целое число), и N чисел соответственно, каждое из которых является разницей между процентом
инфляции k-го месяца и предыдущего (k-1) месяца. Инфляция может быть отрицательной – программа должна учитывать дефляцию
(снижение цены на товар). Следует учитывать, что цена товара не может быть ниже или быть равной нулю –
в этом случае следует вывести сообщение об обвале экономики и завершить программу. В случае некорректного ввода,
просить пользователя ввести значение ещё раз. Необходимо рассчитать и напечатать стоимость товара
по истечению всех месяцев. Округлить полученное значение до двух знаков после запятой.
 */

public class HW52 {

    public static double inputData(Scanner input, String report, boolean inputCheck) {

        double inputNum = 0;
        boolean check = true;
        System.out.println(report);
        do {

            if (input.hasNextDouble()) {

                inputNum = input.nextDouble();
                check = true;
                if (inputCheck && inputNum <= 0) {
                    check = false;
                    System.out.println("Enter a number greater than 0:");
                }
            } else {

                check = false;
                System.out.println("You entered not a number");
                input.nextLine();
            }

        } while (!check);

        return inputNum;
    }

    public static void main(String[] args) {

        final int percentage = 100;
        Scanner input = new Scanner(System.in);
        double cost = inputData(input, "Enter enter the starting price of the product", true);

        double firstInflation = inputData(input, "Enter initial inflation:", false);

        System.out.println("Enter number of months");

        int numberOfMonths = 0;

        boolean test = true;

        do {

            if (input.hasNextInt()) {

                numberOfMonths = input.nextInt();
                test = true;

                if (numberOfMonths <= 0) {

                    test = false;
                    System.out.println("Enter a number greater than 0:");
                }

            } else {

                test = false;
                System.out.println("You entered not an integer number");
                input.nextLine();
            }

        } while (!test);

        double[] nextInflation = new double[numberOfMonths];

        double resultInflation = firstInflation;
        double resultCost = cost;

        for (int i = 0; i < nextInflation.length; ++i) {

            nextInflation[i] = inputData(input, "Enter inflation in the following months", false);

            resultInflation += nextInflation[i];
            resultCost = resultCost * (resultInflation + percentage) / percentage;
            if (resultCost <= 0) {

                System.out.println("The collapse of the economy");
                break;
            }
        }

        if (resultCost > 0) {

            System.out.println(String.format("%.2f", resultCost));
        }

    }
}
