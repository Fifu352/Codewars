//package com.company.A;

import java.util.Scanner;

public class Walking_robot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int b = in.nextInt();
        int a = in.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
        }
        System.out.println(walk(n, b, a, m));
    }

    static int walk(int n, int b, int a, int[] m) {
        int max_distance = 0;
        int b_current = b;
        int a_current = a;
        for (int i : m) {
            if (i == 0) {
                if (a_current > 0) {
                    a_current--;
                    max_distance++;
                } else if (b_current > 0) {
                    b_current--;
                    max_distance++;
                } else {
                    return max_distance;
                }
            } else {
                if (a_current == a) {
                    a_current--;
                    max_distance++;
                } else if (b_current > 0) {
                    b_current--;
                    max_distance++;
                    if (a_current < a) {
                        a_current++;
                    }
                } else if (a_current > 0) {
                    a_current--;
                    max_distance++;
                } else {
                    return max_distance;
                }
            }
        }

        return max_distance;
    }
}
