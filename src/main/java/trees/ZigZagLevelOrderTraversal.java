package trees;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        Tree tree = new Tree(1)
                .setLeft(new Tree(2)
                        .setLeft(new Tree(4).setLeft(new Tree(7)).setRight(new Tree(8)))
                        .setRight(new Tree(5).setLeft(new Tree(9)).setRight(new Tree(10))))
                .setRight(new Tree(3)
                        .setRight(new Tree(6).setLeft(new Tree(11)).setRight(new Tree(12))));

        System.out.println(getZigZagLevelOrderTraversal(tree));
    }

    private static List<Integer> getZigZagLevelOrderTraversal(Tree tree) {
        if (tree == null) {
            return List.of();
        } else {
            boolean flag = false;
            List<Integer> list = new ArrayList<>();
            Queue<Tree> queue = new ArrayDeque<>();
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
