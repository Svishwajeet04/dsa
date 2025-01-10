package recursions;

import java.util.*;

public class SplitStringIntoPalindromes {

    public static void main(String args[]) {
        String str =  "abaca";
        List<List<String>> result =  new ArrayList<>();
        solve(str.charAt(0) + "",  str.substring(1), new ArrayList<>(),result);
        for(var ls : result){
            System.out.println(ls);
        }
    }


    private static void solve(String curr, String str, List<String> currentAns, List<List<String>> result){
        if(str.isEmpty()){
            if(palindrome(curr)){
                currentAns.add(curr);
                result.add(currentAns);
            }
            return;
        }else if(palindrome(curr)){
            currentAns.add(curr);
            solve("" + str.charAt(0),  str.substring(1), new ArrayList<>(currentAns), result);
            currentAns.remove(currentAns.size() - 1);
        }
        solve(curr + str.charAt(0), str.substring(1), new ArrayList<>(currentAns), result);
    }

    private static boolean palindrome(String r){
        for(int i = 0; i < r.length()/2 ; i++){
            if(r.charAt(i) != r.charAt(r.length() - i -1)){
                return false;
            }
        }

        return true;
    }



}