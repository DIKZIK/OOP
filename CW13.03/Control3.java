import java.util.Scanner;

//Регулярка числа в 10ой степени

public class Control3 {

    public static void main(String[] args) {

        System.out.println("Enter your number:");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        if (number.matches("^(([1-9]\\d{0,}" + "(,|\\.){1}\\d{1,})|[1-9]\\d{0,})$")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}