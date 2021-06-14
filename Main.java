package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        final int minPoint = 2;
        int numberOfPoint = 0;
        boolean check;
        System.out.println("Enter number of point:");
        do {

            int buffer;
            if (input.hasNextInt()) {

                buffer = input.nextInt();
                if (buffer > minPoint) {

                    numberOfPoint = buffer;
                    check = true;
                } else {

                    check = false;
                    System.out.println("impossible to build a triangle from less than 3 points");
                }
            } else {

                check = false;
                System.out.println("Enter an integer value");
                input.nextLine();
            }
        } while (!check);

        int[] xCoordinate = new int[numberOfPoint];
        int[] yCoordinate = new int[numberOfPoint];

        for (int i = 0; i < numberOfPoint; ++i) {
            do {

                System.out.println("Enter (__, __): ");
                if (input.hasNextInt()) {

                    xCoordinate[i] = input.nextInt();
                    check = true;
                } else {

                    check = false;
                    System.out.println("Enter an integer value");
                    input.nextLine();
                }
            } while (!check);

            int j = 0;
            do {

                System.out.println("Enter (" + xCoordinate[i] + ",__): ");
                if (input.hasNextInt()) {

                    yCoordinate[j] = input.nextInt();
                    check = true;
                } else {

                    check = false;
                    System.out.println("Enter an integer value");
                    input.nextLine();
                }
                System.out.println("Point: (" + xCoordinate[i] + "," + yCoordinate[j] + ")");
                ++j;
            } while (!check);
        }

        int determinate = 0;
        double square = 0, maxSquare = 0;
        for (int i = 0; i < (numberOfPoint - 2); ++i) {

            for (int j = 0; j < (numberOfPoint - 1); ++j) {

                for(int k = 0; k < numberOfPoint; ++k) {

                    int ab, bc, ca;

                    if((Math.abs(square)) > maxSquare) {

                        maxSquare = (Math.abs(square));
                    }
                }
            }
        }

        System.out.println(maxSquare);
    }
}
