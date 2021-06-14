import java.util.Scanner;

/* Написать регулярное выражение, определяющее является ли заданная строка правильным IPv6-адресом */

public class Reg8 {

    public static void main(String[] args) {

        System.out.println("Еnter ipv6:");
        Scanner input = new Scanner(System.in);
        String ipv6 = input.nextLine();
        if (ipv6.matches("^(::|(([0-9abcdefABCDEF]{1,4}):){7}"
                + "([0-9abcdefABCDEF]{1,4})|(:(:([0-9abcdefABCDEF]{1,4})){1,7})|"
                + "((([0-9abcdefABCDEF]{1,4}):){1,6}:)|((([0-9abcdefABCDEF]{1,4}):)"
                + "(:ss([0-9abcdefABCDEF]{1,4})){1,6})|((([0-9abcdefABCDEF]{1,4})"
                + ":){2}(:([0-9abcdefABCDEF]{1,4})){1,5})|((([0-9abcdefABCDEF]{1,4}):){3}"
                + "(:([0-9abcdefABCDEF]{1,4})){1,4})|((([0-9abcdefABCDEF]"
                + "{1,4}):){4}(:([0-9abcdefABCDEF]{1,4})){1,3})|((([0-9abcdefABCDEF]{1,4}):){5}"
                + "(:([0-9abcdefABCDEF]{1,4})){1,2}))$")) {

            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}