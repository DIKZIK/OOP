import java.util.Scanner;

public class HM21 {

    public static void main(String[] args) {

        System.out.println("Введите вашу строку:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] sumbol = str.toCharArray();
        float code = 0;

        for (int i = 0; i < sumbol.length; i++) {
            code += (int) sumbol[i];
        }
        System.out.println(code / sumbol.length);
    }
}