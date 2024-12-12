package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {

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

        System.out.println(getIterativeInOrder(treeNode));
    }

    private static List<Integer> getIterativeInOrder(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode;
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
