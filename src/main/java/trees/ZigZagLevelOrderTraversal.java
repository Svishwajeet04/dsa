package trees;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1)
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(4).setLeft(new TreeNode(7)).setRight(new TreeNode(8)))
                        .setRight(new TreeNode(5).setLeft(new TreeNode(9)).setRight(new TreeNode(10))))
                .setRight(new TreeNode(3)
                        .setRight(new TreeNode(6).setLeft(new TreeNode(11)).setRight(new TreeNode(12))));

        System.out.println(getZigZagLevelOrderTraversal(tree));
    }

    private static List<Integer> getZigZagLevelOrderTraversal(TreeNode tree) {
        if (tree == null) {
            return List.of();
        } else {
            boolean flag = false;
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> l2 = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    var node = queue.poll();
                    assert node != null;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    l2.add(node.val);
                }
                if(flag){
                    l2.sort(Comparator.reverseOrder());
                    list.addAll(l2);
                }else{
                    list.addAll(l2);
                }
                flag = !flag;
            }
            return list;
        }
    }
}
