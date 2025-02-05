package trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

    public static void main(String[] args) {
        Tree tree = new Tree(3)
                .setLeft(new Tree(5)
                        .setLeft(new Tree(6))
                        .setRight(new Tree(2)
                                .setRight(new Tree(4))
                                .setLeft(new Tree(7)))
                )
                .setRight(new Tree(1)
                        .setLeft(new Tree(0))
                        .setRight(new Tree(8)));
        List<Integer> list = getMorrisTraversalInOrder(tree);
        System.out.println(list);
    }

    private static List<Integer> getMorrisTraversalInOrder(Tree current) {
        List<Integer> list = new ArrayList<>();
        list.add(current.val);
        while (current != null){
            if(current.left == null){
                current = current.right;
            }else{
                Tree rightMost = current.left;
                while (rightMost.right != null && rightMost.right != current) {
                    rightMost = rightMost.right;
                }
                if(rightMost.right == null){
                    rightMost.right = current;
                    current = current.left;
                    list.add(current.val);
                }else{
                    current = current.right;
                    list.add(current.val);
                }
            }
        }
        return list;
    }
}
