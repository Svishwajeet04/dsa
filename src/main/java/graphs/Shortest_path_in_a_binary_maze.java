package graphs;

import java.util.*;

public class Shortest_path_in_a_binary_maze {

//    https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.shortestPath(new int[][]{{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}}, new int[]{0, 1}, new int[]{2,2});
        System.out.println(res);
    }

    static class Solution {

        int shortestPath(int[][] grid, int[] source, int[] destination) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            visited[source[0]][source[1]] = true;
            Queue<List<Integer>> queue = new ArrayDeque<>();
            queue.add(List.of(source[0], source[1]));
            int count = 0;
            while(!queue.isEmpty()){
                int n = queue.size();
                for(int i = 0 ; i < n; i++){
                    List<Integer> node = queue.remove();
                    var ls = findChildren(grid, visited, node, destination);
                    if(ls == null){
                        return count;
                    }
                    queue.addAll(ls);
                }
                count++;
            }

            return -1;
        }

        List<List<Integer>> findChildren(int[][] grid, boolean[][] visited, List<Integer> node, int[] destination){
            int r = node.get(0);
            int c = node.get(1);

            List<List<Integer>> children = new ArrayList<>();
            if(r - 1 >= 0 && !visited[r-1][c] && grid[r-1][c] != 0){
                children.add(List.of(r-1, c));
            }
            if(c-1 >= 0 && !visited[r][c-1] && grid[r][c-1] != 0){
                children.add(List.of(r, c-1));
            }

            if(r + 1 < grid.length && !visited[r+1][c] && grid[r+1][c] != 0){
                children.add(List.of(r+1, c));
            }
            if(c+1 < grid[0].length && !visited[r][c+1] && grid[r][c+1] != 0){
                children.add(List.of(r, c+1));
            }
            for(var child : children){
                if(child.get(0) == destination[0] && child.get(1) == destination[1]){
                    return null;
                }else{
                    visited[child.get(0)][child.get(1)] = true;
                }
            }
            return children;
        }
    }
}
