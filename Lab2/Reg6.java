import java.util.Scanner;

/* Проверить является ли заданная строка n числом, записанным в 16 системе счисления без нулей в старших разрядах. */

public class Reg6 {

    public static void main(String[] args) {

        System.out.println("Еnter a number in 16 base:");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        if (number.matches("(^[1-9ABCDEFabcdef]{1})" + "([0-9ABCDEFabcdef]{0,}$)")) {

            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}