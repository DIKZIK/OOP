package com.company.Regular;
import java.util.Scanner;

/*Написать регулярное выражение, определяющее является ли данная строка строкой "abcdefghijklmnopqrstuv18340" или нет.
– пример правильных выражений: abcdefghijklmnopqrstuv18340.
– пример неправильных выражений: abcdefghijklmnoasdfasdpqrstuv18340. */

public class Reg1 {

    public static void main(String[] args) {

        System.out.println("Enter string:");
        Scanner input = new Scanner(System.in);
        String thisString = input.nextLine();
        if (thisString.matches("^abcdefghijklmnopqrstuv18340")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}