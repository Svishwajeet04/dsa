package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class WaterLockedLand {

    //    https://www.geeksforgeeks.org/problems/number-of-enclaves/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-enclaves
//    Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0}};
        int count = countWaterLockedLand(grid);
        System.out.println(count);
    }

    private static int countWaterLockedLand(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == 0 || j == 0) && grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(List.of(i, j));
                }
                if ((i + 1 == grid.length || j + 1 == grid[0].length) && grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(List.of(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                List<Integer> rc = queue.remove();
                queue.addAll(getChildren(grid, rc, visited));
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static List<List<Integer>> getChildren(int[][] grid, List<Integer> rc, boolean[][] visited) {
        int r = rc.get(0);
        int c = rc.get(1);
        List<List<Integer>> children = new ArrayList<>();
        if (r + 1 < grid.length && grid[r + 1][c] == 1 && !visited[r + 1][c]) {
            visited[r + 1][c] = true;
            children.add(List.of(r + 1, c));
        }
        if (c + 1 < grid[0].length && grid[r][c + 1] == 1 && !visited[r][c + 1]) {
            visited[r][c + 1] = true;
            children.add(List.of(r, c + 1));
        }
        if (c - 1 >= 0 && grid[r][c - 1] == 1 && !visited[r][c - 1]) {
            visited[r][c - 1] = true;
            children.add(List.of(r, c - 1));
        }
        if (r - 1 >= 0 && grid[r - 1][c] == 1 && !visited[r - 1][c]) {
            visited[r - 1][c] = true;
            children.add(List.of(r - 1, c));
        }
        return children;
    }
}
