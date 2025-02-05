package graphs;

import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        int str = 1;
        int stc = 1;
        int newColor = 2;
//        getFloodFill(matrix, str, stc, newColor);
        Solution solution = new Solution();
        var res = solution.floodFill(matrix, 1, 1, newColor);
        System.out.println(Arrays.deepToString(res));
        System.out.println(Arrays.deepToString(matrix));
    }

    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[] { sr, sc });
            int prev = image[sr][sc];
            while (!queue.isEmpty()) {
                Integer[] arr = queue.remove();
                image[arr[0]][arr[1]] = color;
                if (arr[0] - 1 >= 0 && image[arr[0] - 1][arr[1]] == prev) {
                    queue.add(new Integer[] { arr[0] - 1, arr[1] });
                }
                if (arr[0] + 1 < image.length && image[arr[0] + 1][arr[1]] == prev) {
                    queue.add(new Integer[] { arr[0] + 1, arr[1] });
                }
                if (arr[1] - 1 >= 0 && image[arr[0]][arr[1] - 1] == prev) {
                    queue.add(new Integer[] { arr[0], arr[1] - 1 });
                }
                if (arr[1] + 1 < image[0].length && image[arr[0]][arr[1] + 1] == prev) {
                    queue.add(new Integer[] { arr[0], arr[1] + 1 });
                }
            }
            return image;
        }
    }

    private static void getFloodFill(int[][] matrix, int str, int stc, int newColor) {
        int prevColor = matrix[str][stc];
        Queue<List<Integer>> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[str][stc] = true;
        matrix[str][stc] = newColor;
        queue.add(List.of(str, stc));
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> node = queue.remove();
            for (int i = 0; i < n; i++) {
                List<List<Integer>> children = getChildren(prevColor, matrix, node);
                for (List<Integer> child : children) {
                    if (!visited[child.get(0)][child.get(1)]) {
                        queue.add(List.of(child.get(0), child.get(1)));
                        visited[child.get(0)][child.get(1)] = true;
                        matrix[child.get(0)][child.get(1)] = newColor;
                    }
                }
            }
        }
    }

    private static List<List<Integer>> getChildren(int prevColor, int[][] matrix, List<Integer> node) {
        int r = node.get(0);
        int c = node.get(1);
        List<List<Integer>> children = new ArrayList<>();
        if (c + 1 < matrix[0].length && matrix[r][c + 1] == prevColor) {
            children.add(List.of(r, c + 1));
        }
        if (r + 1 < matrix.length && matrix[r + 1][c] == prevColor) {
            children.add(List.of(r + 1, c));
        }
        if (r - 1 >= 0 && matrix[r - 1][c] == prevColor) {
            children.add(List.of(r - 1, c));
        }
        if (c - 1 >= 0 && matrix[r][c - 1] == prevColor) {
            children.add(List.of(r, c - 1));
        }
        return children;
    }
}
