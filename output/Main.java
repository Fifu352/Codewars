import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int array_size = in.nextInt();
            int offset = in.nextInt();

            int[] array_of_inputs = new int[array_size];

            int[] array_of_teams = new int[array_size];
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < array_size; i++) {
                array_of_inputs[i] = in.nextInt();
            }

            System.out.println(teams(array_size, offset, array_of_inputs, array_of_teams));
            long t2 = System.currentTimeMillis();

            System.out.println(t2 - t1);
        }

        static String teams(int array_size, int offset, int[] array_of_inputs, int[] array_of_teams) {
            int max = 0;
            int index = 0;
            int index_l;
            int index_r;
            int team = 1;


            while (true) {
                for (int i = 0; i < array_size; i++) {
                    if (array_of_inputs[i] == max) {

                        index = i;
                        break;
                    }
                    if (array_of_inputs[i] > max && array_of_teams[i] == 0) {
                        max = array_of_inputs[i];
                        index = i;
                    }
                }
                if (max == 0) {
                    StringBuilder builder = new StringBuilder();
                    for (int value : array_of_teams) {
                        builder.append(value);
                    }
                    return builder.toString();
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
                    max--;

                }
            }
        }

    }
}

