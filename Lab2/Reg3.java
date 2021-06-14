import java.util.Scanner;

/*Написать регулярное выражение, определяющее является ли заданная строка правильным IPv4-адресом */

public class Reg3 {

    public static void main(String[] args) {

        System.out.println("Enter ipv4:");
        Scanner input = new Scanner(System.in);
        String ipv4 = input.nextLine();
        if (ipv4.matches("^(?:(([1-9][0-9]|[0-9])|(25[0-5])|(2[0-4][0-9])|(1[0-9][0-9]))(\\.(?!$)|$)){4}$")) {
           
            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}