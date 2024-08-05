package recursions;

import java.util.ArrayList;
import java.util.List;

public class PermuteCaseWithNumber2 {

    public static void main(String[] args) {
        String a = "a1b2c3";
        List<String> strings = new ArrayList<>();
        solvePermuteCaseWithNumber(a, strings, "");
        System.out.println(strings);
    }

    private static void solvePermuteCaseWithNumber(String a, List<String> strings, String output) {
        if(a.isBlank()){
            strings.add(output);
        }else{
            var c = a.charAt(0);
            if(Character.isDigit(c)){
                solvePermuteCaseWithNumber(a.substring(1), strings, output + c);
            }else{
                solvePermuteCaseWithNumber(a.substring(1), strings, output + Character.toUpperCase(c));
                solvePermuteCaseWithNumber(a.substring(1), strings, output + Character.toLowerCase(c));
            }
        }
    }
}
