import java.util.Scanner;

public class HM22 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int sizeArr = 10, max = 9, min = 0, codeSumb = 65;
        int[] numArray = new int[sizeArr];
        System.out.println("enter your numbers");

        for (int i = 0; i < sizeArr; i++) {
            int digit = 0;
            do {
                digit = sc.nextInt();
                if (digit < min || digit > max) {
                    System.out.println("enter a number less than 9 and greater than 0");
                } else {
                    numArray[i] = digit;
                }
            } while (digit < min || digit > max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeArr; i++) {
            numArray[i] += codeSumb;
            sb.append(String.valueOf((char) numArray[i]));
        }
        String result = sb.toString();
        System.out.println("result: \n" + result);
    }
}