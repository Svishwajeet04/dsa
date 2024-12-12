package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] oranges = new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        int n = getTimeToRotAll(oranges);
        System.out.println(n);
    }

    private static int getTimeToRotAll(int[][] oranges) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if (oranges[i][j] == 2) {
                    queue.add(List.of(i, j));
                }
            }
        }
        int count = -1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            count++;
            for (int i = 0; i < n; i++) {
                List<Integer> xy = queue.remove();
                queue.addAll(getChildren(xy, oranges));
            }
        }
        for (int[] orange : oranges) {
            for (int i : orange) {
                if (i == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    private static List<List<Integer>> getChildren(List<Integer> xy, int[][] oranges) {
        int r = xy.get(0);
        int c = xy.get(1);
        List<List<Integer>> children = new ArrayList<>();
        if (r + 1 < oranges.length && oranges[r + 1][c] == 1) {
            oranges[r + 1][c] = 2;
            children.add(List.of(r + 1, c));
        }
        if (c + 1 < oranges[0].length && oranges[r][c + 1] == 1) {
            oranges[r][c + 1] = 2;
            children.add(List.of(r, c + 1));
        }
        if (r - 1 >= 0 && oranges[r - 1][c] == 1) {
            oranges[r - 1][c] = 2;
            children.add(List.of(r - 1, c));
        }
        if (c - 1 >= 0 && oranges[r][c - 1] == 1) {
            oranges[r][c - 1] = 2;
            children.add(List.of(r, c - 1));
        }
        return children;
    }
}
