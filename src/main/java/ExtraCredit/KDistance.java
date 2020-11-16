package ExtraCredit;

import Problem1.TreeNode;

import java.util.*;

public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int m = distanceKHelper(root, target, k);
        result.add(m);
        return result;
    }

    private static int distanceKHelper(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            return distHelper(root, k);
        }
        int n1 = distanceKHelper(root.left, target, k);
        if (n1 != -1) {
            if (n1 + 1 == k) {
                return (root.val);
            } else {
                distHelper(root.right, k - n1 - 2);
            }
            return 1 + n1;
        }
        int n2 = distanceKHelper(root.right, target, k);
        if (n2 != -1) {
            if (n2 + 1 == k) {
                return root.val;
            }
            else {
                distHelper(root.left, k - n2 - 2);
            }
            return 1 + n2;
        }
        return -1;
    }

    private static int distHelper(TreeNode<Integer> root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        if (k == 0) {
            return root.val;
        }
        distHelper(root.left, k - 1);
        distHelper(root.right, k - 1);
        return root.val;
    }
}
