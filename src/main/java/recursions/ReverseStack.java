package recursions;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.push(23);
        integers.push(30);
        integers.push(67);
        integers.push(29);
        integers.push(34);
        integers.push(12);
        reverserStack(integers);
        System.out.println(integers);
    }

    private static void reverserStack(Stack<Integer> integers) {
        if (!integers.isEmpty()) {
            int val = integers.pop();
            reverserStack(integers);
            insertAtLast(val, integers);
        }
    }

    private static void insertAtLast(int val, Stack<Integer> integers) {
        if(integers.isEmpty()){
            integers.push(val);
        }else{
            int pop = integers.pop();
            insertAtLast(val, integers);
            integers.push(pop);
        }
    }
}
