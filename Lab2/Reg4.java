import java.util.Scanner;

//Написать регулярное выражение, определяющее является ли заданная строка правильным MAC-адресом

public class Reg4 {

    public static void main(String[] args) {

        System.out.println("Enter MAC:");
        Scanner input = new Scanner(System.in);
        String mac = input.nextLine();
        if (mac.matches("(^((\\d|[ABCDEF]){2}))(([:]|[-]){1})((\\d|[ABCDEF]){2})((([:]|[-]){1}))((\\d|[ABCDEF]){2})(([:]|[-]){1})((\\d|[ABCDEF]){2})(([:]|[-]){1})((\\d|[ABCDEF]){2})(([:]|[-]){1})(((\\d|[ABCDEF]){2})$)")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}