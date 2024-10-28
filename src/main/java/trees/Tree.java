package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    int val;
    Tree left;
    Tree right;

    public Tree setVal(int val) {
        this.val = val;
        return this;
    }

    public Tree setLeft(Tree left) {
        this.left = left;
        return this;
    }

    public Tree setRight(Tree right) {
        this.right = right;
        return this;
    }

    public Tree(int val) {
        this.val = val;
    }

    public Tree() {
    }
    // Method to calculate the height of the tree
    public int getHeight(Tree root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // Method to print the tree structure
    public void printTreeStructure() {
        if (this == null) return;

        // Calculate the height of the tree
        int height = getHeight(this);

        // Queue to do level order traversal
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);

        int maxWidth = (int) Math.pow(2, height) - 1; // Maximum width of the tree

        // Process each level
        for (int level = 1; level <= height; level++) {
            int levelNodes = (int) Math.pow(2, level - 1); // Nodes at the current level
            int spacing = maxWidth / levelNodes; // Calculate spacing between nodes

            for (int i = 0; i < levelNodes; i++) {
                if (queue.isEmpty()) {
                    System.out.print(" ");
                    continue;
                }

                Tree currentNode = queue.poll();

                if (currentNode != null) {
                    // Print current node with leading spaces
                    System.out.print(" ".repeat(spacing / 2) + currentNode.val + " ".repeat(spacing / 2));
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                } else {
                    // Print empty space for null nodes
                    System.out.print(" ".repeat(spacing));
                    queue.add(null);
                    queue.add(null);
                }
            }
            System.out.println(); // Move to the next line after printing a level
        }
    }



}
