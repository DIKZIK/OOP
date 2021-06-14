import java.util.Scanner;

public class Lab3v2 {

    public static void main(String[] args) {

        int quant = 0;
        Scanner sc1 = new Scanner(System.in);

        System.out.print("enter the number of strings:");

        if (sc1.hasNextInt()) {
            quant = sc1.nextInt();
        } else {
            System.out.println("You entered not an integer");
        }

        String[] str = new String[quant];
        sc1.nextLine();
        for (int i = 0; i < quant; i++) {
            System.out.println("enter strings #" + (i + 1) + ":");
            str[i] = sc1.nextLine();
        }

        String result = new String();
        result = str[0];
        for (int i = 1; i < quant; i++) {
            if (result.length() > str[i].length()) {
                result = str[i];
            }
        }
        System.out.println("shortest string is:   " + result + "  string length is:  " + result.length());
    }
}