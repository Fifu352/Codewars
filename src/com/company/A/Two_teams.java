package com.company.A;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Two_teams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int array_size = in.nextInt();
        int offset = in.nextInt();
        SortedSet<Player> set_of_inputs = new TreeSet<Player>();
        Player[] array_of_players = new Player[array_size];
        int[] array_of_teams = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            array_of_players[i] = new Player(in.nextInt(), i);
            set_of_inputs.add(array_of_players[i]);
        }
        System.out.println(teams(array_size, offset, set_of_inputs, array_of_teams, array_of_players));
    }

    static String teams(int array_size, int offset, SortedSet<Player> set_of_inputs, int[] array_of_teams, Player[] array_of_players) {
        int index = 0;
        int index_l;
        int index_r;
        int team = 1;

        while (!set_of_inputs.isEmpty()) {
            index = set_of_inputs.last().iterator;
            index_l = index;
            index_r = index;

            for (int i = 0; i < offset + 1; i++) {
                if (i == 0) {
                    set_of_inputs.remove(array_of_players[index]);
                    array_of_teams[index] = team;
                } else {
                    while (true) {
                        if (index_r + i < array_size) {
                            if (array_of_teams[index_r + i] == 0) {
                                set_of_inputs.remove(array_of_players[index_r + i]);
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
                                set_of_inputs.remove(array_of_players[index_l - i]);
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
        }
        StringBuilder result = new StringBuilder();
        for (int value : array_of_teams) {
            result.append(value);
        }
        return result.toString();
    }

    static class Player implements Comparable<Player> {
        int value;
        int iterator;

        Player(int value, int iterator) {
            this.value = value;
            this.iterator = iterator;

        }

        public int compareTo(Player a) {
            if (value > a.value) {
                return 1;
            } else if (value < a.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
