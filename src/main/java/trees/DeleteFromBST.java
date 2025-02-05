package trees;

public class DeleteFromBST {

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


        tree = deleteFromBST(tree, 5);
        System.out.println(tree);
    }

    private static Tree deleteFromBST(Tree tree, int i) {
        if(tree.val == i){
            if(tree.left != null){
                var lrm = findRightMostTree(tree.left);
                lrm.right = tree.right;
                tree = tree.left;
                return tree;
            }else{
                tree = tree.right;
                return tree;
            }
        }
        var curr = tree;
        while (curr != null){
            if(curr.val > i){
                if(curr.left != null && curr.left.val == i){
                    if(curr.left.left != null ){
                        var lrm = findRightMostTree(curr.left.left);
                        lrm.right = curr.left.right;
                        curr.left = curr.left.left;
                        return tree;
                    }else{
                        curr.left = curr.left.right;
                        return tree;
                    }
                }else{
                    curr = curr.left;
                }
            }else{
                if(curr.right != null && curr.right.val == i){
                    if(curr.right.left != null ){
                        var lrm = findRightMostTree(curr.right.left);
                        lrm.right = curr.right.right;
                        curr.right = curr.right.left;
                        return tree;
                    }else{
                        curr.right = curr.right.right;
                        return tree;
                    }
                }else{
                    curr = curr.right;
                }
            }
        }
        return tree;
    }

    private static Tree findRightMostTree(Tree tree){
        while (tree.right != null){
            tree = tree.right;
        }
        return tree;
    }
}
