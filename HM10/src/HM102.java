import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Iterator;

public class HM102 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int number = 0;
        boolean check = true;
        System.out.println("Введите числовой ряд, чтобы прекратить ввод, введите любой не числовой символ");
        while (check) {
            int buffer;
            if (input.hasNextInt()) {
                number = input.nextInt();
                numbers.add(number);
                check = true;
                input.nextLine();
            } else {
                check = false;
                input.nextLine();
            }
        }
        int[] nums = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); ++i) {
            nums[i] = numbers.get(i);
        }
        System.out.println(Arrays.toString(findLongestSequence(nums)));
    }

    public static int[] findLongestSequence(int[] nums) {

        TreeSet<Integer> sortNumbers = new TreeSet<>();
        int startNum = 0;
        int checkNum = -1;
        int finalNum = 0;
        int[] result = new int[2];

        for (int i = 0; i < nums.length; ++i) {
            sortNumbers.add(nums[i]);
        }

        Iterator<Integer> iterator = sortNumbers.iterator();
        int temp = 0;
        while (iterator.hasNext()) {
            nums[temp] = iterator.next();
            temp++;
        }

        int i = 0;
        for (i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] - nums[i] == 1) {
                ++startNum;
            } else {
                if (finalNum < startNum) {
                    finalNum = startNum;
                    checkNum = i;
                }
                startNum = 0;
            }
        }
        if (finalNum < startNum) {
            finalNum = startNum;
            checkNum = i;
        }

        result[0] = nums[checkNum - finalNum];
        result[1] = nums[checkNum];
        return result;
    }
}
