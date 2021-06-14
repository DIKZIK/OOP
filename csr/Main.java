import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String inputToConvert = input.nextLine();
        String regular = " ";
        String[] sumbol = inputToConvert.split(regular);
        StringBuffer numberStringBuffer = new StringBuffer();

        numberStringBuffer.append(sumbol[1]);
        String numbersString = numberStringBuffer.toString();
        double temperature = Double.parseDouble(numbersString);

      switch (sumbol[0]) {
            case "F":

                System.out.println(String.format("%.2f", ToF.converter(temperature)));
                break;
            case "N":

                System.out.println(String.format("%.2f", ToN.converter(temperature)));
                break;
            case "K":

                System.out.println(String.format("%.2f", ToK.converter(temperature)));
                break;
        }

    }
}
