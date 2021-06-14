import java.util.Scanner;

public class HM23 {

    public static void main(String[] args) {

        System.out.println("enter your numbers");
        Scanner sc = new Scanner(System.in);
        final int sizeArr = 3;
        float[] num = new float[sizeArr];
        for (int i = 0; i < sizeArr; i++) {
            num[i] = sc.nextFloat();
        }

        float result1 = 0, result2 = 0, result3 = 0;
        for (int i = 0; i < sizeArr; i++) {
            result1 += num[i];
            result2 += (int) num[i];
            result3 = result1 - result2;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result1).append("\n").append(result2).append("\n").append(result3);
        String result = sb.toString();
        System.out.println("result:\n" + result);
    }
}