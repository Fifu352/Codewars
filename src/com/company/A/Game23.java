package com.company.A;

import java.util.Scanner;

public class Game23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(isPossible(n, m));

    }

    public static int isPossible(int n, int m) {
        int holder = m / n;
        int twos = 0;
        int thress = 0;
        if (m % n == 0 && (holder%2==0 || holder %3==0)) {
            while (holder % 2 == 0) {
                twos++;
                holder = holder / 2;
            }
            while (holder % 3 == 0) {
                thress++;
                holder = holder / 3;
            }
            if(holder ==1) {
                return twos + thress;
            }
        } else if (m == n){
            return 0;
        }
        return -1;


    }

}