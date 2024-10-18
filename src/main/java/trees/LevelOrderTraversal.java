package trees;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Tree tree = new Tree(1)
                .setLeft(new Tree(2)
                        .setLeft(new Tree(4))
                        .setRight(new Tree(5)))
                .setRight(new Tree(3)
                        .setRight(new Tree(6)));

        System.out.println(getLevelOrderTraversal(tree));
    }

    private static List<Integer> getLevelOrderTraversal(Tree tree) {
        if (tree == null) {
            return List.of();
        }else{
            List<Integer> list = new ArrayList<>();
            Deque<Tree> stack = new ArrayDeque<>();
            stack.add(tree);
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
