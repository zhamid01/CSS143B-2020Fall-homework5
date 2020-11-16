package ExtraCredit;

import Problem1.TreeNode;

import java.util.*;

/*
This site was used as help on this code:
https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
*/

public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        distanceKHelper(root, target, k, result);
        return result;
    }

    private static int distanceKHelper(TreeNode<Integer> root, TreeNode<Integer> target, int k, List<Integer> result) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            distHelper(target, k, result);
            return 0;
        }
        int n1 = distanceKHelper(root.left, target, k, result);
        if (n1 != -1) {
            if (n1 + 1 == k) {
                result.add(root.val);
            } else {
                distanceHelper(root.right, k - n1 - 2, result);
            }
            return 1 + n1;
        }
        int n2 = distanceKHelper(root.right, target, k, result);
        if (n2 != -1) {
            if (n2 + 1 == k) {
                result.add(root.val);
            }
            else {
                distanceHelper(root.left, k - n2 - 2, result);
            }
            return 1 + n2;
        }
        return -1;
    }

    private static List<Integer> distHelper(TreeNode<Integer> root, int k, List<Integer> result) {
        if (root == null || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(root.val);
            return result;
        }
        distHelper(root.left, k - 1, result);
        distHelper(root.right, k - 1, result);
        return result;
    }

    private static int distanceHelper(TreeNode<Integer> root, int k, List<Integer> result) {
        if (root == null || k < 0) {
            return 0;
        }
        if (k == 0) {
            result.add(root.val);
            return root.val;
        }
        distanceHelper(root.left, k - 1, result);
        distanceHelper(root.right, k - 1, result);
        return root.val;
    }
}
