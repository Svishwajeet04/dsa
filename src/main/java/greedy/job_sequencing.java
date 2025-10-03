package greedy;

import java.util.Arrays;

public class job_sequencing {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = new int[][]{
                {1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}
        };
        System.out.println(Arrays.toString(solution.JobScheduling(jobs)));
    }

    static class Solution {
        public int[] JobScheduling(int[][] jobs) {
            int max = Integer.MIN_VALUE;
            for (var a : jobs) {
                max = Math.max(a[1], max);
            }
            int[] time = new int[max + 1];
            Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
            for (int[] i : jobs) {
                int k = i[1];
                while (k > 0 && time[k] != 0) {
                    k--;
                }
                if (k > 0) {
                    time[k] = i[2];
                }
            }
            int sum = 0;
            int count = 0;
            for (int k : time) {
                if (k > 0) {
                    count++;
                    sum += k;
                }
            }
            return new int[]{count, sum};
        }

    }
}
