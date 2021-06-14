import java.util.Scanner;

/* Написать регулярное выражение для Формата ISO 8601 */

public class Reg11 {

    public static void main(String[] args) {

        System.out.println("Еnter date:");
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        if (date.matches("")) {

            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}