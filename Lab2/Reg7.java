import java.util.Scanner;

/* Создать запрос для вывода только правильно написанных выражений со скобками (количество открытых и закрытых скобок должно быть одинаково).
– пример правильных выражений: (3 + 5) – 9 × 4.
– пример неправильных выражений: ((3 + 5) – 9 × 4. */

public class Reg7 {

    public static void main(String[] args) {

        System.out.println("Enter expression:");
        Scanner input = new Scanner(System.in);
        String parentheses = input.nextLine();
        if (parentheses.matches("")) {

            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}