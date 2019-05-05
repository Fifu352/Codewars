package com.company.A;

import java.util.Arrays;
import java.util.Scanner;

public class Diverse_Strings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = in.next();
        }
        for (String word : words) {
            System.out.println(checkString(word));
        }
    }

    private static String checkString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int start = (int) arr[0];
        int end = (int) arr[arr.length - 1];
        boolean checker_1 = true;

        if (arr.length == 1) {
            return "Yes";
        }
        if (arr.length < 3) {
            if (Math.abs(end - start) == 1) {
                return "Yes";
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (((int) arr[i] == start + 1)) {
                start++;
            } else {
                checker_1 = false;
                break;
            }
        }

        if (checker_1) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
