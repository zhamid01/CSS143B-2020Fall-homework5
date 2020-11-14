package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> tree = new LinkedList<TreeNode>();
        tree.add(root);
        while (tree.size() != 0) {
            List<Integer> list1 = new ArrayList<>();
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> n1 = tree.poll();
                list1.add(n1.val);
                if (n1.left != null) {
                    tree.add(n1.left);
                }
            }


        }
        return result;
    }
}
