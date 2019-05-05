package com.company.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Parity_Alternated_Deletions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
        }
        System.out.println(minimize(n, m));
    }

    static int minimize(int n, int[] m) {
        int oddNumbers = 0;
        int evenNumbers = 0;
        int sum_index = 0;
        int sum = 0;

        ArrayList<Integer> evens = new ArrayList<Integer>();
        ArrayList<Integer> odds = new ArrayList<Integer>();

        for (int number : m) {
            if (number % 2 == 1) {
                odds.add(number);
                oddNumbers++;
            } else if (number % 2 == 0) {
                evens.add(number);
                evenNumbers++;
            }
        }

        Collections.sort(evens);
        Collections.sort(odds);

        if (oddNumbers == evenNumbers || oddNumbers + 1 == evenNumbers || oddNumbers == evenNumbers + 1) {
            return 0;
        } else if (oddNumbers > evenNumbers) {
            sum_index = oddNumbers - evenNumbers - 1;

            for (int i = 0; i < sum_index; i++) {
                sum += odds.get(i);
            }
        } else if (evenNumbers > oddNumbers) {
            sum_index = evenNumbers - oddNumbers - 1;

            for (int i = 0; i < sum_index; i++) {
                sum += evens.get(i);
            }
        }
        return sum;
    }
}
