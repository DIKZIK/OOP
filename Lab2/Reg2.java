    import java.util.Scanner;

/*Написать регулярное выражение, определяющее является ли данная строчка шестнадцатиричным идентификатором цвета в HTML.
Где #FFFFFF для белого, #000000 для черного, #FF0000 для красного и т.д. */

public class Reg2 {

    public static void main(String[] args) {

        System.out.println("Enter color code:");
        Scanner input = new Scanner(System.in);
        String thisString = input.nextLine();
        if (thisString.matches("^([#]{1})(\\d|[ABCDEF]){6}")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}