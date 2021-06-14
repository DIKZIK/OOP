import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int numberOfRating = 5;
        Scanner input = new Scanner(System.in);
        System.out.println("enter number of students:");
        int number = 0;
        boolean check;
        do {
            check = true;
            if (input.hasNextInt()) {
                number = input.nextInt();
            } else {
                check = false;
                System.out.println("You entered not an integer");
                input.nextLine();
            }
        } while (!check);

        Student[] students = new Student[number];
        input.nextLine();
        for (int i = 0; i < number; ++i) {
            String fio;
            String initials;
            String group;
            int[] rating = new int[numberOfRating];
            System.out.println("enter fio Student #" + (i + 1) + ":");
            fio = input.nextLine();
            System.out.println("enter initials Student #" + (i + 1) + ":");
            initials = input.nextLine();
            System.out.println("enter group Student #" + (i + 1) + ":");
            group = input.nextLine();
            System.out.println("enter marks Student #" + (i + 1) + ":");
            for (int j = 0; j < rating.length; ++j) {
                do {
                    check = true;
                    if (input.hasNextInt()) {
                        int buffer = 0;
                        do {
                            buffer = input.nextInt();
                            if ((buffer < 0) || (buffer > 10)) {
                                System.out.println("enter marks > 0 and marks < 10");
                            } else {
                                rating[j] = buffer;
                            }
                        } while ((buffer > 10) || (buffer < 0));

                    } else {
                        check = false;
                        System.out.println("You entered not an integer");

                    }
                    input.nextLine();
                } while (!check);

            }
            students[i] = new Student(fio, initials, group, rating);
        }

        for (int i = 0; i < number; ++i) {
            int goodStudent = 0;
            for (int j = 0; j < numberOfRating; ++j) {
                if (students[i].rating[j] >= 9) {
                    ++goodStudent;
                }
            }
            if (goodStudent == 5) {
                System.out.println(students[i].getStudentInfo());
            }
        }

    }
}