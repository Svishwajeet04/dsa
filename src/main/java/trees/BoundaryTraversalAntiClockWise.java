package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoundaryTraversalAntiClockWise {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1)
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(4).setLeft(new TreeNode(7)).setRight(new TreeNode(8)))
                        .setRight(new TreeNode(5).setLeft(new TreeNode(9)).setRight(new TreeNode(10))))
                .setRight(new TreeNode(3)
                        .setRight(new TreeNode(6).setLeft(new TreeNode(11)).setRight(new TreeNode(12))));

        System.out.println(getBoundaryTraversalAntiClockWise(tree, 0, new ArrayList<Integer>(), new HashMap<Integer, Integer>()));
    }

    private static List<Integer> getBoundaryTraversalAntiClockWise(TreeNode tree, int i, ArrayList<Integer> ls, HashMap<Integer, Integer> map) {
        return null;
    }
}
