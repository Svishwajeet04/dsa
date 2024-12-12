package trees;

import com.sun.source.tree.Tree;

public class DeleteANodeInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.right = new TreeNode(12);
        root.right.right = new TreeNode(13);
        root.right.left = new TreeNode(9);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        root = deleteANode(15, root);
        System.out.println(root);
    }

    private static TreeNode deleteANode(int val, TreeNode root) {
        if(root.val == val){
            if(root.left != null){
                TreeNode right = root.left;
                while (right.right != null) {
                    right = right.right;
                }
                right.right = root.right;
                return root.left;
            }else{
                return root.right;
            }
        }else{
            TreeNode curr = root;
            boolean left = false;
            boolean found = false;
            while (true){
                if(curr.left != null && curr.left.val == val){
                    found = true;
                    left = true;
                    break;
                } else if (curr.right != null && curr.right.val == val) {
                    found = true;
                    break;
                }else if(curr.val > val){
                    curr = curr.left;
                }else{
                    curr = curr.right;
                }
                if(curr == null){
                    break;
                }
            }
            if(found){
                if(left){
                    if(curr.left.left != null){
                        TreeNode right = curr.left.left;
                        while (right.right != null) {
                            right = right.right;
                        }
                        right.right = curr.left.right;
                    }else{
                        curr.left = curr.left.right;
                    }
                }else{
                    if(curr.right.left != null){
                        TreeNode right = curr.right.left;
                        while (right.right != null) {
                            right = right.right;
                        }
                        right.right = curr.right.right;
                    }else{
                        curr.right = curr.right.right;
                    }
                }
            }
            return root;
        }
    }
}
