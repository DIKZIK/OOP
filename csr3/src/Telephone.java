import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Telephone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> messages = new ArrayList<>();
        int check = 0;
        do {
            ++check;
            messages.add(input.nextLine());
        } while (!messages.get(check - 1).equals(""));
        String[] messagesWithNumber = new String[messages.size()];
        final String telephoneReg = "^(.*(8|7|//+7)?([0-9] ?){10}.*)$";
        for (int i = 0; i < messages.size() - 1; ++i) {
            if (messages.get(i).matches(telephoneReg)) {
                Pattern pattern = Pattern.compile("([0-9] ?){10}");
                Matcher matcher = pattern.matcher(messages.get(i));
                matcher.find();
                String number = matcher.group();
                String[] newNumber = number.split(" ");
                StringBuilder correctNumber = new StringBuilder();
                correctNumber.append("Correct:+7");
                for (int j = 0; j < newNumber.length; ++j) {
                    correctNumber.append(newNumber[j]);
                }
                System.out.println(correctNumber.toString());
            } else {
                System.out.println("No");
            }
        }
    }
}