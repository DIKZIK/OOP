import java.util.Scanner;

public class Lab2v2 {

    public static void main(String[] args) {

        System.out.println("Enter your string:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println("Enter the length of the word you want to remove");
        Scanner sc1 = new Scanner(System.in);
        int wLen = 0;
        if (sc1.hasNextInt()) {
            wLen = sc1.nextInt();
        } else {
            System.out.println("You entered not an integer");
        }

        String[] wordsSplit = str.split("\\b");
        StringBuilder sb = new StringBuilder();
        for (String words : wordsSplit) {
            char sumb = words.charAt(0);
            if (!((words.length() == wLen) && ((Character.toString(sumb).matches("[qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM]"))))) {
                sb.append(words);
            }
        }
        String result = sb.toString();
        System.out.println(result);
    }
}