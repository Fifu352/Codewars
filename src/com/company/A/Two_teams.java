package com.company.A;

import java.util.Scanner;

public class Two_teams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int array_size = in.nextInt();
        int offset = in.nextInt();
        int[] array_of_inputs = new int[array_size];
        int[] array_of_teams = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            array_of_inputs[i] = in.nextInt();
        }

        System.out.println(teams(array_size, offset, array_of_inputs, array_of_teams));

    }

    static String teams(int array_size, int offset, int[] array_of_inputs, int[] array_of_teams) {
        int max = 0;
        int index = 0;
        int index_l;
        int index_r;
        int team = 1;
        int temp_max = 999999999;

        while (true) {
            for (int i = 0; i < array_size; i++) {
                if ( array_of_teams[i] == 0) {
                    if(array_of_inputs[i] > max){
                        max = array_of_inputs[i];
                        index = i;
                    }
                }
                if (max == temp_max) {
                    break;
                }
            }

            if (max == 0) {
                StringBuilder result = new StringBuilder();
                for (int value : array_of_teams) {
                    result.append(value);
                }
                return result.toString();
            } else {
                index_l = index;
                index_r = index;

                for (int i = 0; i < offset + 1; i++) {
                    if (i == 0) {
                        array_of_teams[index] = team;
                    } else {
                        while (true) {
                            if (index_r + i < array_size) {
                                if (array_of_teams[index_r + i] == 0) {
                                    array_of_teams[index_r + i] = team;
                                    break;
                                }
                                index_r++;
                            } else {
                                break;
                            }
                        }
                        while (true) {
                            if (index_l - i > -1) {
                                if (array_of_teams[index_l - i] == 0) {
                                    array_of_teams[index_l - i] = team;
                                    break;
                                }
                                index_l--;
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (team == 2) {
                    team = 1;
                } else {
                    team = 2;
                }
                temp_max = max - 1;
                max = 0;
            }
        }
    }
}
