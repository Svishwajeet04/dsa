package trees;

import java.util.*;

public class BottomViewOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1)
                .setRight(new TreeNode(7).setRight(new TreeNode(8)
                        .setLeft(new TreeNode(9)
                                .setLeft(new TreeNode(10))
                                .setRight(new TreeNode(11)))))
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(3)
                                .setRight(new TreeNode(4)
                                        .setLeft(new TreeNode(5))
                                        .setRight(new TreeNode(6)))));
        List<Integer> topView = new ArrayList<>(getTop(root, new HashMap<>(), 0)
                .entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue).toList());
        System.out.println(topView);
    }

    private static Map<Integer,Integer> getTop(TreeNode root, Map<Integer, Integer> integers, int curr) {
        if(root != null){
            integers.put(curr, root.val);
            getTop(root.left, integers, curr -1);
            getTop(root.right, integers, curr + 1);
        }
        return integers;
    }
}
