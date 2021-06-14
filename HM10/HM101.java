import java.util.Scanner;

public class HM101 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Введите размерность матрицы:");
        int size = 0;
        boolean check = true;
        while (check) {
            check = false;
            int buffer;
            if (input.hasNextInt()) {
                buffer = input.nextInt();
                if (buffer < 1) {
                    System.out.println("размерность матрицы должна быть больше 0");
                    check = true;
                } else {
                    size = buffer;
                    check = false;
                }
            } else {
                System.out.println("Вы ввели не число, попробуйте заново:");
                check = true;
                input.nextLine();
            }
        }
        snake(size);
    }

    public static void snake(int size) {

        int[][] snakeMatrix = new int[size][size];

        int x = 0;
        int y = 0;
        int xCheck = 0;
        int yCheck = 1;
        for (int i = 1; i <= size * size; ++i) {
            snakeMatrix[x][y] = i;
            if (((y + yCheck) >= size) ||
                    ((y + yCheck) < 0) ||
                    ((x + xCheck) >= size) ||
                    ((x + xCheck) < 0) ||
                    (snakeMatrix[x + xCheck][y + yCheck] != 0)) {
                int temp = yCheck;
                yCheck = -xCheck;
                xCheck = temp;
            }
            x += xCheck;
            y += yCheck;
        }
        for (int i = 0; i < size; ++i) {
            System.out.print("\n");
            for (int j = 0; j < size; ++j) {
                System.out.print(snakeMatrix[i][j]);
                System.out.print("\t");
            }
        }
    }
}
