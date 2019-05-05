package com.company.A;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Two_teams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int array_size = in.nextInt();
        int offset = in.nextInt();
        TreeSet<Player> set_of_inputs = new TreeSet<>(new ValueComp());
        TreeSet<Player> set_of_iterators = new TreeSet<>(new IterComp());
        Player[] array_of_players = new Player[array_size];
        int[] array_of_teams = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            array_of_players[i] = new Player(in.nextInt(), i);
            set_of_inputs.add(array_of_players[i]);
            set_of_iterators.add(array_of_players[i]);
        }
        System.out.println(teams(offset, set_of_inputs, array_of_teams, array_of_players, set_of_iterators));
    }

    static String teams(int offset, TreeSet<Player> set_of_inputs, int[] array_of_teams, Player[] array_of_players, TreeSet<Player> set_of_iterators) {
        int index = 0;
        int team = 1;

        while (!set_of_inputs.isEmpty()) {
            index = set_of_inputs.last().iterator;

            for (int i = 1; i < offset + 1; i++) {
                if (set_of_iterators.higher(array_of_players[index]) != null) {
                    array_of_teams[set_of_iterators.higher(array_of_players[index]).iterator] = team;
                    set_of_inputs.remove(set_of_iterators.higher(array_of_players[index]));
                    set_of_iterators.remove(set_of_iterators.higher(array_of_players[index]));
                }
                if (set_of_iterators.lower(array_of_players[index]) != null) {
                    array_of_teams[set_of_iterators.lower(array_of_players[index]).iterator] = team;
                    set_of_inputs.remove(set_of_iterators.lower(array_of_players[index]));
                    set_of_iterators.remove(set_of_iterators.lower(array_of_players[index]));
                }
            }
            set_of_inputs.remove(array_of_players[index]);
            set_of_iterators.remove(array_of_players[index]);
            array_of_teams[index] = team;

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

    static class Player {
        int value;
        int iterator;

        Player(int value, int iterator) {
            this.value = value;
            this.iterator = iterator;
        }

        public int getValue() {
            return value;
        }

        public int getIterator() {
            return iterator;
        }
    }

    static class ValueComp implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            return Integer.compare(p1.getValue(), p2.getValue());

        }
    }

    static class IterComp implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            return Integer.compare(p1.getIterator(), p2.getIterator());

        }
    }
}
