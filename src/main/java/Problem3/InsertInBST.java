package Problem3;

import Problem1.TreeNode;

public class InsertInBST {
    public static void insert(TreeNode<Integer> root, int valToInsert) {
        if (root == null) {
            root = new TreeNode<Integer>(valToInsert);
            return;
        }
    }
}
