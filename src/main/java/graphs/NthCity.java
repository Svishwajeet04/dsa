package graphs;

public class NthCity {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheCity(5, new int[][]{
                {0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}
//                {0, 3, 7}, {2, 4, 1}, {0, 1, 5}, {2, 3, 10}, {1, 3, 6}, {1, 2, 1}
        }, 2));
    }

    static class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] weight = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    weight[j][i] = Integer.MAX_VALUE;
                    if (j == i) {
                        weight[j][i] = 0;
                    }
                }
            }
            for (int[] edge : edges) {
                weight[edge[0]][edge[1]] = edge[2];
                weight[edge[1]][edge[0]] = edge[2];
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (weight[i][k] != Integer.MAX_VALUE && weight[k][j] != Integer.MAX_VALUE) {
                            weight[i][j] = Math.min(weight[i][j], weight[i][k] + weight[k][j]);
                        }
                    }
                }
            }
            int[] count = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (weight[i][j] != 0 && weight[i][j] <= distanceThreshold) {
                        ++count[i];
                    }
                }
            }
            int min = 0;
            for (int i = 1; i < n; i++) {
                if (count[i] <= count[min]) {
                    min = i;
                }
            }
            return min;
        }
    }
}
