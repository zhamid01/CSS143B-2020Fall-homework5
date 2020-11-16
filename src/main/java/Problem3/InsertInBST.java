package Problem3;

import Problem1.TreeNode;

/*
This site was used as help in this code:
https://www.geeksforgeeks.org/insert-a-node-in-binary-search-tree-iteratively/
*/

public class InsertInBST {
    public static void insert(TreeNode<Integer> root, int valToInsert) {
        if (root == null) {
            return;
        }
        TreeNode<Integer> n1 = new TreeNode<Integer>(valToInsert);
        TreeNode<Integer> main = root;
        TreeNode<Integer> n2 = null;

        while (main != null) {
            n2 = main;
            if (valToInsert < main.val) {
                main = main.left;
            } else {
                main = main.right;
            }
        }
        if (n2 == null) {
            n2.left = n1;
        }
        else if (valToInsert < n2.val) {
            n2.left = n1;
        }
        else {
            n2.right = n1;
        }
    }
}
