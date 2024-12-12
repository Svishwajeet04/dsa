package graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDFs {

    public static void main(String[] args) {
         Solution solution = new Solution();
        System.out.println(solution
                .isCycle(List.of(List.of(1), List.of(0,2,4), List.of(1,3), List.of(2,4), List.of(1,3))));
    }

    static class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(List<List<Integer>> adj) {
            return isCycle(adj, 0, -1, new boolean[adj.size()]);
        }

        public boolean isCycle(List<List<Integer>> adj, int curr, int parent, boolean[] visited){
            visited[curr]  = true;
            for(int i : adj.get(curr)){
                if(i != parent && visited[i]){
                    return true;
                }else{
                    if(!visited[i]){
                        if (isCycle(adj, i, curr, visited)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
