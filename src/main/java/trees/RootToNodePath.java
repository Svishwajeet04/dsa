package trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
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
                        .setRight(new Tree(6)
                                .setLeft(new Tree(6))
                                .setRight(new Tree(7))));
        List<Integer> ls = new ArrayList<>();
        getRootToNodePath(tree, ls, 7);
        System.out.println(ls);
    }

    private static boolean getRootToNodePath(Tree tree, List<Integer> ls, int i) {
        if(tree == null){
            return false;
        }else{
            ls.add(tree.val);
            if(tree.val == i){
                return true;
            }else{
                boolean left = getRootToNodePath(tree.left, ls, i);
                boolean res = left || getRootToNodePath(tree.right, ls, i);
                if(!res){
                    ls.remove(ls.size() -1);
                }
                return res;
            }
        }
    }
}
