package trees;

import java.util.ArrayList;
import java.util.List;

public class KthNodeInBST {

    public static void main(String[] args) {
        Tree tree = new Tree(8)
                .setRight(new Tree(12)
                        .setRight(new Tree(13))
                        .setLeft(new Tree(10)))
                .setLeft(new Tree(5)
                        .setLeft(new Tree(2)
                                .setLeft(new Tree(1))
                                .setRight(new Tree(3)
                                        .setRight(new Tree(4))))
                        .setRight(new Tree(7)
                                .setLeft(new Tree(6))
                                .setRight(new Tree(8))));
        ArrayList<Integer> ls = new ArrayList<>();
        getKthNodeInBST(tree, ls);
        System.out.println(ls.get( 5 - 1));
    }

    private static void getKthNodeInBST(Tree tree, List<Integer> ls) {
        if (tree != null) {
            getKthNodeInBST(tree.left, ls);
            ls.add(tree.val);
            getKthNodeInBST(tree.right, ls);
        }
    }
}
