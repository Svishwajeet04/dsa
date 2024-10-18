package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoundaryTraversalAntiClockWise {

    public static void main(String[] args) {
        Tree tree = new Tree(1)
                .setLeft(new Tree(2)
                        .setLeft(new Tree(4).setLeft(new Tree(7)).setRight(new Tree(8)))
                        .setRight(new Tree(5).setLeft(new Tree(9)).setRight(new Tree(10))))
                .setRight(new Tree(3)
                        .setRight(new Tree(6).setLeft(new Tree(11)).setRight(new Tree(12))));

        System.out.println(getBoundaryTraversalAntiClockWise(tree, 0, new ArrayList<Integer>(), new HashMap<Integer, Integer>()));
    }

    private static List<Integer> getBoundaryTraversalAntiClockWise(Tree tree, int i, ArrayList<Integer> ls, HashMap<Integer, Integer> map) {
        return null;
    }
}
