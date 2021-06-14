import java.util.Scanner;

//МКАД
public class Control1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        final int s = 109;
        int v = 0;
        int t = 0;
        System.out.println("input v:");
        v = input.nextInt();
        System.out.println("input t:");
        t = input.nextInt();
        int s1 = (v * t);
        int result = 0;

        if (v > 0) {

            result = (s - s1);
            System.out.println(Math.abs(result));
        } else {
            result = (s - s1);
            System.out.println("-" + result);
        }
    }
}