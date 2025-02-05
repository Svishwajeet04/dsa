package graphs;

import java.util.*;

public class AccountMerge {

    public static void main(String[] args) {
        System.out.println(Solution.accountsMerge(
                List.of(
                        List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                        List.of("John","johnsmith@mail.com","john00@mail.com"),
                        List.of("Mary","mary@mail.com"),
                        List.of("John","johnnybravo@mail.com"))
        ));
    }
    static class Solution {
        static List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, List<String>> parentMap = new HashMap<>();
            Map<String, String> emailNameMap = new HashMap<>();
            for(var ls: accounts){
                String name = ls.get(0);
                for(int i = 1; i < ls.size(); i++){
                    String email1 = ls.get(i);
                    emailNameMap.put(email1, name);
                    for(int j = i + 1; j < ls.size(); j++){
                        String email2 = ls.get(j);
                        parentMap.putIfAbsent(email1, new ArrayList<>());
                        parentMap.putIfAbsent(email2, new ArrayList<>());
                        parentMap.get(email1).add(email2);
                        parentMap.get(email2).add(email1);
                    }
                }
            }
            List<List<String>> result = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            for(String email : emailNameMap.keySet()){
                if(visited.add(email)){
                    List<String> connected = new ArrayList<>();
                    dfs(email, connected, visited, parentMap);
                    Collections.sort(connected);
                    connected.add(0, emailNameMap.get(email));
                    result.add(connected);
                }
            }
            return result;
        }

        static void dfs(String email, List<String> connected, Set<String> visited, Map<String, List<String>> parentMap){
            connected.add(email);
            List<String> children = parentMap.get(email);
            if(children != null){
                for(String child : children){
                    if(visited.add(child)){
                        dfs(child, connected, visited, parentMap);
                    }
                }
            }
        }
    }
}
