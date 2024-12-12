package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {

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

        System.out.println(getIterativePostOrderTraversal(treeNode));
    }

    private static List<Integer> getIterativePostOrderTraversal(TreeNode treeNode) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        stack.push(treeNode);
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
