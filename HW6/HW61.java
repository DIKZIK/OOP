//package com.company;

/*
Программа считывает целочисленные значения с консоли в три независимых коллекции.
В начале работы программа ожидает ввод числа в первую коллекцию.
Переключение между коллекциями осуществляется вводом в консоль команды «STREAM 1», «STREAM 2» и «STREAM 3».
Ввод чисел и переключение между коллекциями в программе должно продолжаться до тех пор,
пока в консоль не будет введена команда конца ввода – «END».
После окончания ввода программа должна сформировать новую коллекцию чисел, каждое число в котором является суммой
чисел из одной и той же позиции из каждой коллекции. При этом, если в одной коллекции отсутствует число по заданной позиции,
то есть числа в нём закончились, то необходимо найти сумму чисел из двух других коллекций.
Если чисел по заданной позиции нет уже в двух коллекциях – итоговый поток просто дозаполняется числами из той коллекции,
где они остались. Итоговую коллекцию чисел вывести на печать в одну строку. Также, в ходе работы программы допускается случаи,
когда любая коллекция не будет содержать числа. Если же все коллекции пустые, вывести сообщение, что итоговая коллекция пуста.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class HW61 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> third = new ArrayList<>();

        boolean check = true;

        final String selectionFirstStream = "STREAM 1";
        final String selectionSecondStream = "STREAM 2";
        final String selectionThirdStream = "STREAM 3";
        final String selectionEnd = "END";

        String streamSelection = selectionFirstStream;

        do {

            int buffer = 0;
            if (input.hasNextInt()) {

                buffer = input.nextInt();
                input.nextLine();

                check = true;

                switch (streamSelection) {
                    case selectionFirstStream -> first.add(buffer);
                    case selectionSecondStream -> second.add(buffer);
                    case selectionThirdStream -> third.add(buffer);
                    default -> System.out.println("Error");
                }

            } else {

                String bufferLine = null;

                bufferLine = input.nextLine();


                if (bufferLine.matches("^STREAM [123]$")) {

                    streamSelection = bufferLine;
                    check = true;
                } else if (bufferLine.matches("^END$")) {

                    check = false;
                } else {

                    check = true;
                    System.out.println("You entered incorrect data");
                }

            }
        } while (check);


        int maxListSize = Math.max(first.size(), Math.max(second.size(), third.size()));

        if (maxListSize == 0) {

            System.out.println("All collection is empty");
        } else {

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < maxListSize; ++i) {

                int resultNumber = 0;

                if (i < first.size()) {

                    resultNumber += first.get(i);
                }

                if (i < second.size()) {

                    resultNumber += second.get(i);
                }

                if (i < third.size()) {

                    resultNumber += third.get(i);
                }

                result.append(resultNumber).append(" ");

            }

            System.out.println("Вывод:\n" + result.toString());
        }

    }
}
