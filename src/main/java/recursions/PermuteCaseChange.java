package recursions;

import java.util.ArrayList;
import java.util.List;

public class PermuteCaseChange {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        permute(ls, "abc");
        System.out.println(ls);
    }

    private static void permute(List<String> ls, String s) {
        if (s.length() != 1) {
            String c = s.charAt(0) + "";
            permute(ls, s.substring(1));
            List<String> l2 = new ArrayList<>();
            for (String st : ls) {
                l2.add(c.toUpperCase() + st);
                l2.add(c.toLowerCase() + st);
            }
            ls.clear();
            ls.addAll(l2);
        } else {
            String c = s.charAt(0) + "";
            ls.add(c.toUpperCase());
            ls.add(c.toLowerCase());
        }
    }
}
