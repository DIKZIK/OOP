import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HW91 {

    public static int generator(int max) {

        return (int) (Math.random() * ++max);
    }

    public static Integer[] hallows(int[][] array) {

        ArrayList<Integer> hallows = new ArrayList<>();

        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {

                if (array[i][j] == 0) {

                    hallows.add(sizeOfHallows(array, i, j, 0));
                }
            }
        }
        Collections.sort(hallows);
        Integer[] result = hallows.toArray(new Integer[0]);
        return result;
    }

    public static int sizeOfHallows(int[][] array, int i, int j, int sizeOfArray) {

        int sizeOfHallow = 0;

        if (i < array.length && j < array[i].length) {

            if (array[i][j] == 0) {

                array[i][j] = 1;
                ++sizeOfHallow;
                sizeOfHallow += sizeOfHallows(array, i + 1, j, sizeOfArray + 1);
                sizeOfHallow += sizeOfHallows(array, i, j + 1, sizeOfArray + 1);
                if (i > 0) {
                    sizeOfHallow += sizeOfHallows(array, i - 1, j, sizeOfArray + 1);
                }
                if (j > 0) {
                    sizeOfHallow += sizeOfHallows(array, i, j - 1, sizeOfArray + 1);
                }
            }
        }
        return sizeOfHallow;
    }

    public static void main(String[] args) {

        final int lowLimit = 1;
        final int highLimit = 5;
        final int maxCellValue = 1;
        int x = lowLimit + (int) (Math.random() * highLimit);
        int y = lowLimit + (int) (Math.random() * highLimit);
        int[][] array = new int[x][y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {

                array[i][j] = generator(maxCellValue);
            }
        }

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {

                System.out.print(array[i][j]);
            }
            System.out.println();
        }


        System.out.println(Arrays.toString(hallows(array)));
    }
}
