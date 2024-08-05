package recursions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateValidParantheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateValidParantheses(n);
        System.out.println(strings);
    }

    private static List<String> generateValidParantheses(int n) {
        List<String> list = new ArrayList<>();
        generateValidParantheses(list, "", n, n);
        return list;
    }

    private static void generateValidParantheses(List<String> list, String s, int opening, int closing) {
        if (opening == 0 && closing == 0) {
            list.add(s);
        } else {
            if (s.isEmpty() && opening != 0) {
                generateValidParantheses(list, s + "(", opening - 1, closing);
            }else {
                if(checkIfValidParantheses(s + ")")){
                    generateValidParantheses(list, s + ")", opening , closing -1);
                }
                if(opening != 0){
                    generateValidParantheses(list, s + "(", opening - 1, closing);
                }
            }
        }
    }

    private static boolean checkIfValidParantheses(String s) {
        Stack<Character> characters = new Stack<>();
        while (!s.isEmpty()){
            char c = s.charAt(0);
            if(c == '('){
                characters.add(c);
            }else{
                if(!characters.isEmpty()){
                    var last = characters.pop();
                    if (last != '(') {
                        return false;
                    }
                }else{
                    return false;
                }
            }
            s = s.substring(1);
        }
        return true;
    }
}
