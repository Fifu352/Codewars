import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TwoToOne {
    public static String longest(String s1, String s2) {
        String temp_string = s1 + s2;
        Set<Character> set_of_chars = new HashSet<Character>();
        for (char character : temp_string.toCharArray()) {
            set_of_chars.add(character);
        }
        ArrayList<Character> list_of_chars = new ArrayList(set_of_chars);
        Collections.sort(list_of_chars);
        String s = "";
        for (char c : list_of_chars) {
            s += c;
        }
        return s;
    }

}