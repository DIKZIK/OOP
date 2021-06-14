import java.util.Scanner;

/* Написать регулярное выражение, определяющее является ли данная строка UUID с или без скобок. */

public class Reg10 {

    public static void main(String[] args) {

        System.out.println("Еnter UUID:");
        Scanner input = new Scanner(System.in);
        String uuid = input.nextLine();
        if (uuid.matches("((^[{(]{1})[0-9abcdefABCDEF]{8}-([0-9abcdefABCDEF]{4}-){3}[0-9abcdefABCDEF]{12}([})]{1}$)|(^[0-9abcdefABCDEF]{8}-([0-9abcdefABCDEF]{4}-){3}[0-9abcdefABCDEF]{12}$))")) {

            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}