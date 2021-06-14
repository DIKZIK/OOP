package com.company.HM41;

import java.util.Scanner;

public class HM42 {

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
                if (buffer >= minPoint) {

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
        int[] zCoordinate = new int[numberOfPoint];

        for (int i = 0; i < numberOfPoint; ++i) {
            do {

                System.out.println("Enter (__, __, __): ");
                if (input.hasNextInt()) {

                    xCoordinate[i] = input.nextInt();
                    check = true;
                } else {

                    check = false;
                    System.out.println("Enter an integer value");
                    input.nextLine();
                }
            } while (!check);


            do {

                System.out.println("Enter (" + xCoordinate[i] + ", __, __): ");
                if (input.hasNextInt()) {

                    yCoordinate[i] = input.nextInt();
                    check = true;
                } else {

                    check = false;
                    System.out.println("Enter an integer value");
                    input.nextLine();
                }
                System.out.println("Point: (" + xCoordinate[i] + "," + yCoordinate[i] + ", __)");

            } while (!check);

            do {

                if (input.hasNextInt()) {

                    zCoordinate[i] = input.nextInt();
                    check = true;
                } else {

                    check = false;
                    System.out.println("Enter an integer value");
                    input.nextLine();
                }
                System.out.println("Point: (" + xCoordinate[i] + "," + yCoordinate[i] + "," + zCoordinate[i] + ")");

            } while (!check);

        }

        double minDistance = 0, distance = 0;
        int minCoordinates = 0;
        for (int i = 0; i < numberOfPoint; ++i) {

            for (int j = 0; j < numberOfPoint; ++j) {

                distance += Math.sqrt(Math.pow(xCoordinate[j] - xCoordinate[i], 2) + Math.pow(yCoordinate[j] - yCoordinate[i], 2) + Math.pow(zCoordinate[j] - zCoordinate[i], 2));
            }

            if (i == 0 || distance < minDistance) {

                minDistance = distance;
                minCoordinates = i;
            }

            distance = 0;
        }

        System.out.println("(" + xCoordinate[minCoordinates] + "," + yCoordinate[minCoordinates] + "," + zCoordinate[minCoordinates] + ") " + String.format("%.2f", minDistance));
    }
}

