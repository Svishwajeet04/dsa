package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MInEfforts {

    static class Pair implements Comparable<Pair> {
        int effort;
        int x;
        int y;

        public Pair(int effort, int x, int y) {
            this.effort = effort;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.effort - o.effort;
        }
    }

    public static void main(String[] args) {
        int res = Solution.MinimumEffort(3, 3, new int[][]{
                {1,2,2},
                {3,8,2},
                {5,3,5}
        });
        System.out.println(res);
    }

    private static class Solution {
        public static int MinimumEffort(int rows, int columns, int[][] heights) {
            Queue<Pair> queue = new PriorityQueue<>(Pair::compareTo);
            int[][] value = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    value[i][j] = Integer.MAX_VALUE;
                }
            }
            queue.add(new Pair(0, 0, 0));
            value[0][0] = 0;
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Pair node = queue.remove();
                    List<Pair> children = getChildren(node, heights, value, rows, columns);
                    queue.addAll(children);
                }
            }
            return value[rows - 1][columns - 1];
        }

        private static List<Pair> getChildren(Pair node, int[][] height, int[][] value, int rows, int columns) {
            int x = node.x;
            int y = node.y;
            List<Pair> children = new ArrayList<>();
            if(x + 1 < rows){
                int val = value[x+1][y];
                value[x+1][y] = Math.min(value[x+1][y], Math.max(Math.abs(height[x+1][y] - height[x][y]), value[x][y]));
                if(val != value[x+1][y]){
                    children.add(new Pair(value[x+1][y], x+1, y));
                }
            }
            if(y + 1 < columns){
                int val = value[x][y + 1];
                value[x][y+1] = Math.min(value[x][y+1], Math.max(Math.abs(height[x][y+1] - height[x][y]), value[x][y]));
                if(val != value[x][y + 1]){
                    children.add(new Pair(value[x][y + 1], x, y + 1));
                }
            }
            if(x - 1 >= 0){
                int val = value[x- 1][y];
                value[x-1][y] = Math.min(value[x-1][y], Math.max(Math.abs(height[x-1][y] - height[x][y]), value[x][y]));
                if(val != value[x-1][y]){
                    children.add(new Pair(value[x-1][y], x-1, y));
                }
            }
            if(y - 1 >= 0){
                int val = value[x][y- 1];
                value[x][y-1] = Math.min(value[x][y-1], Math.max(Math.abs(height[x][y-1] - height[x][y]), value[x][y]));
                if(val != value[x][y- 1]){
                    children.add(new Pair(value[x][y- 1], x, y- 1));
                }
            }
            return children;
        }
    }
}
