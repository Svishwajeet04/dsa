package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {


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

        System.out.println(getIterativePreOrder(tree));
    }

    private static List<Integer> getIterativePreOrder(Tree tree) {
        List<Integer> ls = new ArrayList<>();
        Stack<Tree> stack = new Stack<>();
        stack.add(tree);
        while(!stack.isEmpty()){
            var node = stack.pop();
            ls.add(node.val);
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }
        return ls;
    }
}
