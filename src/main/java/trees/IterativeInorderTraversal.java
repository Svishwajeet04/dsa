package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {

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

        System.out.println(getIterativeInOrder(tree));
    }

    private static List<Integer> getIterativeInOrder(Tree tree) {
        List<Integer> result = new ArrayList<>();
        Stack<Tree> stack = new Stack<>();
        Tree node = tree;
        while (node != null || !stack.isEmpty()){
            if(node == null){
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            } else{
                stack.add(node);
                node = node.left;
            }
        }
        return result;
    }
}
