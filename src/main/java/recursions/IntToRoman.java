package recursions;

import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(4549));
    }

    static class Solution {

        public String intToRoman(int num) {
            int pow = 0;
            StringBuilder s = new StringBuilder();
            var map = Map.of(1.0, "I", 5.0, "V", 10.0, "X", 50.0, "L", 100.0, "C", 500.0, "D", 1000.0, "M");
            for (int i = num; i > 0; i = i / 10) {
                int dig = i % 10;
                if (dig == 4) {
                    s.insert(0, map.get(Math.pow(10, pow) * 5));
                    s.insert(0, map.get(Math.pow(10, pow)));
                } else if (dig == 9) {
                    s.insert(0, map.get(Math.pow(10, pow + 1)));
                    s.insert(0, map.get(Math.pow(10, pow)));
                } else if (dig == 5) {
                    s.insert(0, map.get(Math.pow(10, pow) * 5));
                } else if (dig < 4) {
                    for (int j = 1; j <= dig; j++) {
                        s.insert(0, map.get(Math.pow(10, pow)));
                    }
                } else {
                    for (int j = dig - 5; j > 0; j--) {
                        s.insert(0, map.get(Math.pow(10, pow)));
                    }
                    s.insert(0, map.get(Math.pow(10, pow) * 5));
                }
                pow++;
            }
            return s.toString();
        }
    }
}