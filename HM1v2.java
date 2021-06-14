import java.io.*;
import java.util.*;


class HM1v2 {
    public static void main(String args[]) {
        System.out.println("enter the text:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chArr = str.toCharArray();


        for (int i = 0; i < chArr.length; i++) {
            if (Character.isLetter(chArr[i])) {
                chArr[i] = ' ';
            }
        }
        String answer = String.valueOf(chArr);
        String[] ansArr = answer.split("[ ;!?]+");



        int[] intArr = new int[ansArr.length];
        int j = 0, changes = 0;
        for (int i = 0; i < ansArr.length; i++) {
            try {
                intArr[j] = Integer.parseInt(ansArr[i]);
                j++;
                changes++;
            } catch (Exception e) {

            }
        }
        Arrays.sort(intArr);
        for (int i = (intArr.length - changes); i <= changes + 1; i++) {
            System.out.println("element[" + i + "]=" + intArr[i]);
        }

    }
}