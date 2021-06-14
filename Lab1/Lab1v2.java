package com.company;

import java.util.Scanner;

public class Lab1v2 {

    public static void main(String[] args) {

        System.out.println("enter your string:");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        System.out.println("enter the number of the replacement character:");
        int posChange = 0;

        if (sc.hasNextInt()) {
            posChange = sc.nextInt();
        } else {
            System.out.println("You entered not an integer");
        }
        sc.nextLine();
        System.out.println("enter a sumbol to replace:");
        char replaceSumbol = sc.next().charAt(0);

        String[] words = inputString.split(" ");
        int maxLen = words[0].length();
        for (String wordLen : words) {
            if (wordLen.length() > maxLen) {
                maxLen = wordLen.length();
            }
        }
        char[][] sumbolsFromWords = new char[words.length][maxLen];
        int[] len = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                sumbolsFromWords[i][j] = words[i].charAt(j);
                if (Character.isLetter(sumbolsFromWords[i][j])) {
                    len[i]++;
                }
            }
        }
        String[] wordsReplace = new String[words.length];
        StringBuilder sbWordsReplace = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (posChange <= len[i]) {
                sumbolsFromWords[i][posChange - 1] = replaceSumbol;
            }
            sbWordsReplace.append(sumbolsFromWords[i]);
            sbWordsReplace.append(" ");
            wordsReplace[i] = sbWordsReplace.toString().trim();
            sbWordsReplace = new StringBuilder();

        }
        StringBuilder sbRes = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sbRes.append(wordsReplace[i]);
            sbRes.append(" ");
        }
        String resultString = sbRes.toString();
        System.out.println(resultString);
    }
}