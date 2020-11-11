package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> tree = new Stack<>();

        TreeNode<Integer> n1 = root;
        while (n1 != null) {
            tree.push(n1);
            n1 = n1.left;
        }
        while (!tree.isEmpty()) {
            TreeNode<Integer> n2 = tree.pop();
            result.add(n2.val);
            n2 = n2.right;

            while (n2 != null) {
                tree.push(n2);
                n2 = n2.left;
            }
        }
        return result;
    }
}
