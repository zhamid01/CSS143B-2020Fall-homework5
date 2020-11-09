import Problem1.TreeNode;
import Problem2.LCA;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Problem2Test {
    public static class LCATestCase<T> {
        TreeNode<T> tree;
        TreeNode<T> node1;
        TreeNode<T> node2;
        TreeNode<T> expect;

        public LCATestCase(TreeNode<T> tree, T node1, T node2, T expect) {
            this.tree = tree;
            this.node1 = findTreeNodeByValue(node1);
            this.node2 = findTreeNodeByValue(node2);
            this.expect = findTreeNodeByValue(expect);
        }

        private TreeNode<T> findTreeNodeByValue(T val) {
            return findTreeNodeByValueHelper(val, tree);
        }

        private TreeNode<T> findTreeNodeByValueHelper(T val, TreeNode<T> node) {
            if (node == null) {
                return null;
            }

            if (node.val == val) {
                return node;
            }

            TreeNode<T> result = findTreeNodeByValueHelper(val, node.left);
            if (result != null) {
                return result;
            }

            result = findTreeNodeByValueHelper(val, node.right);
            return result;
        }
    }

    @Test
    public void testLCA() {
        List<LCATestCase<Integer>> testCases = getLCATestCases();
        for (int i = 0; i < testCases.size(); i++) {
            LCATestCase<Integer> testCase = testCases.get(i);
            assertEquals(testCase.expect.val, LCA.lowestCommonAncestor(testCase.tree, testCase.node1, testCase.node2).val);
        }
    }

    private List<LCATestCase<Integer>> getLCATestCases() {
        List<LCATestCase<Integer>> testCases = new ArrayList<>();

        //      1
        //     / \
        //    2   N
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        testCases.add(new LCATestCase<>(root, 1, 2, 1));
        testCases.add(new LCATestCase<>(root, 2, 1, 1));

        //      1
        //     / \
        //    2   3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        testCases.add(new LCATestCase<>(root, 1, 2, 1));
        testCases.add(new LCATestCase<>(root, 2, 3, 1));
        testCases.add(new LCATestCase<>(root, 3, 2, 1));

        //          1
        //         /
        //        2
        //       /
        //      3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        testCases.add(new LCATestCase<>(root, 2, 3, 2));
        testCases.add(new LCATestCase<>(root, 3, 2, 2));
        testCases.add(new LCATestCase<>(root, 1, 3, 1));
        testCases.add(new LCATestCase<>(root, 3, 1, 1));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.right.right = new TreeNode<>(3);
        testCases.add(new LCATestCase<>(root, 2, 3, 2));
        testCases.add(new LCATestCase<>(root, 3, 2, 2));
        testCases.add(new LCATestCase<>(root, 1, 3, 1));
        testCases.add(new LCATestCase<>(root, 3, 1, 1));

        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        testCases.add(new LCATestCase<>(root, 4, 5, 2));
        testCases.add(new LCATestCase<>(root, 4, 5, 2));
        testCases.add(new LCATestCase<>(root, 4, 6, 1));
        testCases.add(new LCATestCase<>(root, 4, 3, 1));
        testCases.add(new LCATestCase<>(root, 5, 3, 1));
        testCases.add(new LCATestCase<>(root, 6, 2, 1));

        //             1
        //            /  \
        //           2    3
        //          /  \    \
        //         4    5    6
        //        /    /
        //       7    8
        //      /
        //     9
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.left.left = new TreeNode<>(7);
        root.left.left.left.left = new TreeNode<>(9);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(8);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        testCases.add(new LCATestCase<>(root, 9, 6, 1));
        testCases.add(new LCATestCase<>(root, 9, 1, 1));
        testCases.add(new LCATestCase<>(root, 9, 8, 2));
        testCases.add(new LCATestCase<>(root, 7, 3, 1));

        return testCases;
    }
}