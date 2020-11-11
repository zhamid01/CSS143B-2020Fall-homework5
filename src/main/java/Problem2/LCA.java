package Problem2;

import Problem1.TreeNode;

/*
This site was used as help for this problem:
https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
*/

public class LCA {
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        TreeNode<Integer> n1 = helper(root, p, q);
        return n1;
    }

    private static TreeNode<Integer> helper(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) {
            return null;
        }
        else if (root == p || root == q) {
            return root;
        }
        TreeNode<Integer> left = helper(root.left, p, q);
        TreeNode<Integer> right = helper(root.right, p, q);
        if (left == null) {
            return right;
        }
        else if (right == null) {
            return left;
        }
        return root;
    }
}
