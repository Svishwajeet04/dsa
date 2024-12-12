package trees;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1)
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(4))
                        .setRight(new TreeNode(5)))
                .setRight(new TreeNode(3)
                        .setRight(new TreeNode(6)));

        System.out.println(getLevelOrderTraversal(treeNode));
    }

    private static List<Integer> getLevelOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return List.of();
        }else{
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> stack = new ArrayDeque<>();
            stack.add(treeNode);
            while (!stack.isEmpty()){
                int n = stack.size();
                for (int i = 0; i < n; i++) {
                    var node = stack.remove();
                    list.add(node.val);
                    if(node.left != null){
                        stack.add(node.left);
                    }
                    if(node.right != null){
                        stack.add(node.right);
                    }
                }
            }
            return list;
        }
    }
}
