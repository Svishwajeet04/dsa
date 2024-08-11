package recursions;

import java.util.ArrayList;
import java.util.List;

public class PermuteSpaces {

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }

    static List<String> permutation(String s) {
        List<String> ls = new ArrayList<>();
        ls.add(s.charAt(0) + "");
        // Code Here
        return permutation(s.substring(1), ls);
    }

    static List<String> permutation(String s,  List<String> list){
        if(s.isEmpty()){
            return list;
        }else{
            List<String> l2 = new ArrayList<>();
            char c = s.charAt(0);
            for(String st : list){
                l2.add(st + " " + c);
                l2.add(st + c);
                list = permutation(s.substring(1),  l2);
            }
            return list;
        }
    }
}
