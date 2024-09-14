package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {

    public static void main(String[] args) {
        Tree tree = new Tree()
                .setVal(13)
                .setLeft(new Tree().setVal(1).setLeft(
                                new Tree().setVal(2)
                                        .setLeft(new Tree().setVal(4))
                                        .setRight(new Tree().setVal(5)
                                                .setLeft(new Tree(6))
                                                .setRight(new Tree(7))))
                        .setRight(new Tree(3)))
                .setRight(new Tree(14));

        System.out.println(getIterativePostOrderTraversal(tree));
    }

    private static List<Integer> getIterativePostOrderTraversal(Tree tree) {
        List<Integer> ls = new ArrayList<>();
        Stack<Tree> stack = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        stack.push(tree);
        while(!stack.isEmpty()){
            var node = stack.pop();
            st2.push(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        while (!st2.isEmpty()){
            ls.add(st2.pop());
        }
        return ls;
    }
}
