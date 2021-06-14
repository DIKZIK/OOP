import java.util.Scanner;

public class HM24 {

    public static void main(String[] args) {

        System.out.println("Enter your String:");
        Scanner sc = new Scanner(System.in);
        String input = new String();
        boolean check;
        final int codeA = 65, codea = 97, codeSpace = 32;
        do {
            check = true;
            input = sc.nextLine();
            for (int i = 0; i < input.length(); i++) {
                if (!(Character.isLetter(input.charAt(i)) || (input.charAt(i) == ' '))) {
                    check = false;
                    System.out.println("there should be only letters and space in the string");
                }
            }
        } while (check == false);

        StringBuilder sb = new StringBuilder();
        int sumbInt = 0;
        for (int i = 0; i < input.length(); i++) {
            sumbInt = (int) input.charAt(i);
            ++sumbInt;
            if (input.charAt(i) == ' ') {
                sumbInt = codeSpace;
            } else if (input.charAt(i) == 'z') {
                sumbInt = codea;
            } else if (input.charAt(i) == 'Z') {
                sumbInt = codeA;
            }

            sb.append(String.valueOf((char) (sumbInt)));
        }

        String result = sb.toString();
        System.out.println("result: \n" + result);
    }
}