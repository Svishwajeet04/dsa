package trees;

public class TreeCreationInPreOrder {

    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] preorder = {10, 20, 40, 50, 30, 60};
        Tree root = getTree(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
        System.out.println(root);
    }

    private static Tree getTree(final int[] inorder, final int[] preorder, int ins, int ine, int ps, int pe) {
        if(ine > ins){
            Tree tree = new Tree(preorder[ps]);
            int line = 0;
            for (int i = ps; i <= ine; i++) {
                if (preorder[ps] == inorder[i]) {
                    line = i - 1;
                    break;
                }
            }
            int lps = ps + 1;
            int lpe = lps + line - ins;
            tree.setLeft(getTree(inorder, preorder, ins, line, lps, lpe));
            int rps = lpe + 1;
            int rins = line + 2;
            tree.setRight(getTree(inorder, preorder, rins, ine, rps, pe));
            return tree;
        }else{
            if(ins == ine){
                return new Tree(inorder[ins]);
            }else{
                return null;
            }
        }
    }
}
