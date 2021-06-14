import java.util.Scanner;


//Буквы на числа

public class Control2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("enter the text");
        String text = input.nextLine();
        StringBuilder sb = new StringBuilder();
        int sumbInt = 0;
        int toUpReg = 33;
        char[] sumbolsFromString = text.toCharArray();
        for (int i = 0; i < text.length(); ++i) {
            if (Character.toString(sumbolsFromString[i]).matches("[qwertyuiopasdfghjklzxcvbnm]")) {
                sumbInt = (int) text.charAt(i);
                sb.append("[" + (sumbInt) + "]");
            } else if (Character.toString(sumbolsFromString[i]).matches("[QWERTYUIOPASDFGHJKLZXCVBNM]")) {
                sumbInt = (int) text.charAt(i);
                sb.append("[" + (sumbInt+ toUpReg) + "]");
            } else {
                sb.append(sumbolsFromString[i]);
            }

        }
        System.out.println(sb.toString());

    }
}
