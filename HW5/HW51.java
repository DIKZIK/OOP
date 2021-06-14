//package com.company;

import java.util.Scanner;

/*
В консоль вводится целое число k. В случае некорректного ввода, просить пользователя ввести число ещё раз.
Необходимо определить, существует ли такое число n, что 1+2+3+...+n=k.
 В качестве ответа вывести значение true / false. Также, в случае если число n существует, вывести значение числа n.
 */

public class HW51 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number:");
        boolean check;
        int kNumber = 0;

        do {

            if (input.hasNextInt()) {

                kNumber = input.nextInt();
                check = true;
                if (kNumber <= 0) {
                    check = false;
                    System.out.println("Enter a number that is great than 0");
                }
            } else {

                check = false;
                System.out.println("Enter an integer value");
                input.nextLine();
            }

        } while (!check);

        int i = 0, result = 0;
        boolean booleanAnswer = true;

        while (result < kNumber) {

            ++i;
            result += i;
            if (result == kNumber) {

                System.out.println(booleanAnswer);
                System.out.println(i);
            } else if (result > kNumber) {

                System.out.println(!booleanAnswer);
            }

        }
    }
}
