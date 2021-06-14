import java.util.Scanner;

import static java.lang.Math.*;

public class Fibonachi {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int firstNumber = input.nextInt();
        int secondNumber = input.nextInt();

        StringBuilder result = new StringBuilder();
        int resultNumber = 0;
        for (int i = firstNumber; i < secondNumber; ++i) {

            resultNumber = (int) round(((pow(((1+sqrt(5))/2), i)- (pow((1-sqrt(5))/2, i)))/sqrt(5)));
            result.append(resultNumber).append(" ");

        }
        System.out.println(result.toString());
    }
}
