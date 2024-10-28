package trees;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Tree tree = new Tree()
                .setVal(13)
                .setLeft(new Tree().setVal(1).setLeft(
                                new Tree().setVal(2)
                                        .setLeft(new Tree().setVal(4))
                                        .setRight(new Tree().setVal(5)
                                                .setLeft(new Tree(6))
                                                .setRight(new Tree(7))))
                        .setRight(new Tree(3)))
                .setRight(new Tree(14));

        System.out.println(getLowestCommonAncestor(tree, 3, 14));
    }

    private static Integer getLowestCommonAncestor(Tree tree, int x , int y) {
        if(tree == null){
            return null;
        }
        if(tree.val == x || tree.val == y){
            return tree.val;
        }else{
            Integer xv = getLowestCommonAncestor(tree.left, x , y);
            Integer yv = getLowestCommonAncestor(tree.right, x , y);
            if(xv != null & yv != null && xv != yv){
                return tree.val;
            }
            if(xv != null){
                return xv;
            }else{
                return yv;
            }
        }
    }
}
