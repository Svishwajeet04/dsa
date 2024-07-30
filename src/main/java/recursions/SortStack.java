package recursions;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.push(23);
        integers.push(30);
        integers.push(67);
        integers.push(29);
        integers.push(34);
        integers.push(12);
        sort(integers);
        System.out.println(integers);
    }

    private static void sort(Stack<Integer> integers) {
        if (integers.size() != 1) {
            int val = integers.pop();
            sort(integers);
            Stack<Integer> stack = new Stack<>();
            while (true) {
                if (integers.isEmpty()) {
                    integers.push(val);
                    while (!stack.isEmpty()) {
                        integers.push(stack.pop());
                    }
                    break;
                }
                int val1 = integers.pop();
                if (val1 < val) {
                    integers.push(val1);
                    integers.push(val);
                    while (!stack.isEmpty()) {
                        integers.push(stack.pop());
                    }
                    break;
                } else {
                    stack.push(val1);
                }
            }
        }
    }


}
