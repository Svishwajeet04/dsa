package recursions;

import java.util.ArrayList;
import java.util.List;

public class PermuteCaseWithNumber {

    public static void main(String[] args) {
        String a = "a1b2c3";
        List<String> strings = new ArrayList<>();
        solvePermuteCaseWithNumber(a, strings);
        System.out.println(strings);
    }

    private static void solvePermuteCaseWithNumber(String a, List<String> strings) {
        if (a.length() != 1) {
            solvePermuteCaseWithNumber(a.substring(1), strings);
            List<String> l2 = new ArrayList<>();
            for (String str : strings) {
                if (Character.isDigit(a.charAt(0))) {
                    l2.add(a.charAt(0) + str);
                } else {
                    l2.add(Character.toUpperCase(a.charAt(0)) + str);
                    l2.add(Character.toLowerCase(a.charAt(0)) + str);
                }
            }
            strings.clear();
            strings.addAll(l2);
        } else {
            List<String> l2 = new ArrayList<>();
            if (Character.isDigit(a.charAt(0))) {
                l2.add(a.charAt(0) + "");
            } else {
                l2.add(Character.toUpperCase(a.charAt(0)) + "");
                l2.add(Character.toLowerCase(a.charAt(0)) + "");
            }
            strings.clear();
            strings.addAll(l2);
        }
    }
}
