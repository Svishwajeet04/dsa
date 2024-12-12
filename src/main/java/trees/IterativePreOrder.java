package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode()
                .setVal(13)
                .setLeft(new TreeNode().setVal(1).setLeft(
                        new TreeNode().setVal(2)
                                        .setLeft(new TreeNode().setVal(4))
                                        .setRight(new TreeNode().setVal(5)
                                                .setLeft(new TreeNode(6))
                                                .setRight(new TreeNode(7))))
                        .setRight(new TreeNode(3)))
                .setRight(new TreeNode(14));

        System.out.println(getIterativePreOrder(treeNode));
    }

    private static List<Integer> getIterativePreOrder(TreeNode treeNode) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode);
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
