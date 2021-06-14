import java.util.Scanner;

/* Проверить, надежно ли составлен пароль. Пароль считается надежным, если он состоит из 8 или более символов.
Где символом может быть английская буква, цифра и знак подчеркивания.
Пароль должен содержать хотя бы одну заглавную букву, одну маленькую букву и одну цифру. */

public class Reg5 {

    public static void main(String[] args) {

        System.out.println("Enter password:");
        Scanner input = new Scanner(System.in);
        String pass = input.nextLine();
        if (pass.matches("(?=.*[0-9])(?=.*[A-Za-z])[0-9A-Za-z_]{8,}")) {

            System.out.println("true");
        } else {

            System.out.println("false");
        }
    }
}