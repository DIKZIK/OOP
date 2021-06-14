package com.company;

/*
Программа принимает две строки на вход. Первая строка содержит наборы значений в виде «<строка>:<целое число>»,
 где строка может содержать только буквы из английского и русского алфавита и пробелы,
 а числа являются положительными и уникальными, не повторяются. Каждый набор разделяется символом «;» (точка с запятой).
 Вторая строка содержит набор целых чисел, разделённых символом «-» (тире).
 Необходимо составить строку, заменив числа из второй строки, сохранив порядок и убрав символы тире, строками
 из первой строки, для которых задано соответствующее число. В случае отсутствия соответствия чисел –
 наличие числа во второй строке и его отсутствии в первой – вместо числа подставлять символ «_» (подчёркивание).
 */

import java.util.HashMap;
import java.util.Scanner;

public class HW63 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String inputString = null;
        String regularExpression = "^([A-Za-zА-Яа-я ]+:\\d+;)*([A-Za-zА-Яа-я ]+):\\d+$";

        System.out.println("Enter your string:");
        do {

            inputString = input.nextLine();
            if (inputString.matches(regularExpression)) {
                break;
            } else {

                System.out.println("Wrong input, try again:");
                input.nextLine();
            }
        } while (!inputString.matches(regularExpression));

        String inputSecondString = null;
        String numbersRegular = "^(\\d+-)*\\d+$";

        System.out.println("Enter numbers to replace:");

        do {

            inputSecondString = input.nextLine();
            if (inputSecondString.matches(numbersRegular)) {

                break;
            } else {

                System.out.println("Wrong input, try again:");
            }
        } while (!inputSecondString.matches(numbersRegular));

        String[] sets = inputString.split(";");
        HashMap<Integer, String> lettersCode = new HashMap<>();

        for (int i = 0; i < sets.length; ++i) {

            String[] setCode = sets[i].split(":");
            lettersCode.put(Integer.valueOf(setCode[1]), setCode[0]);

        }

        StringBuilder result = new StringBuilder();
        String[] numbers = inputSecondString.split("-");
        for (int i = 0; i < numbers.length; ++i) {

            String changes = lettersCode.getOrDefault(Integer.valueOf(numbers[i]), "_");

            result.append(changes);
        }

        System.out.println(result.toString());

    }
}
