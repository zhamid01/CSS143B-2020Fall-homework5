import Problem1.InOrderTraverse;
import Problem1.LevelOrderTraverse;
import Problem1.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Problem1Test {

    public static class InOrderTestCase<T> {
        final TreeNode<T> tree;
        final List<T> expect;

        public InOrderTestCase(TreeNode<T> tree, List<T> expect) {
            this.tree = tree;
            this.expect = expect;
        }
    }

    public static class LevelOrderTestCase<T> {
        TreeNode<T> tree;
        List<List<T>> expect;

        public LevelOrderTestCase(TreeNode<T> tree, List<List<T>> expect) {
            this.tree = tree;
            this.expect = expect;
        }
    }

    @Test
    public void testInorderTraversal() {
        List<InOrderTestCase<Integer>> testCases = getInOrderTraverseTestCases();
        for (int i = 0; i < testCases.size(); i++) {
            InOrderTestCase<Integer> testCase = testCases.get(i);
            List<Integer> result = InOrderTraverse.inorderTraversalIterative(testCase.tree);
            assertEquals(testCase.expect, result);
        }
    }

    @Test
    public void testLevelOrderTraversal() {
        List<LevelOrderTestCase<Integer>> testCases = getLevelOrderTraverseTestCases();
        for (int i = 0; i < testCases.size(); i++) {
            LevelOrderTestCase<Integer> testCase = testCases.get(i);
            List<List<Integer>> actual = LevelOrderTraverse.levelOrder(testCase.tree);
            assertEquals(testCase.expect.toString(), actual.toString());
        }
    }

    private List<InOrderTestCase<Integer>> getInOrderTraverseTestCases() {
        List<InOrderTestCase<Integer>> testCases = new ArrayList<>();


        // empty (root==null) tree
        testCases.add(new InOrderTestCase<>(null, new ArrayList<>()));

        //      1
        //     / \
        //    N   N
        testCases.add(new InOrderTestCase<>(new TreeNode<>(1), Arrays.asList(1)));

        //      1
        //     / \
        //    2   N
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        testCases.add(new InOrderTestCase<>(root, Arrays.asList(2, 1)));

        //      1
        //     / \
        //    N   3
        root = new TreeNode<>(1);
        root.right = new TreeNode<>(3);
        testCases.add(new InOrderTestCase<>(root, Arrays.asList(1, 3)));

        //      1
        //     / \
        //    2   3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        testCases.add(new InOrderTestCase<>(root, Arrays.asList(2, 1, 3)));

        //          1
        //         /
        //        2
        //       /
        //      3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        testCases.add(new InOrderTestCase<>(root, Arrays.asList(3, 2, 1)));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.right.right = new TreeNode<>(3);
        testCases.add(new InOrderTestCase<>(root, Arrays.asList(1, 2, 3)));

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
        testCases.add(new InOrderTestCase<>(root, Arrays.asList(4, 2, 5, 1, 3, 6)));

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
        testCases.add(new InOrderTestCase<>(root, Arrays.asList(9, 7, 4, 2, 8, 5, 1, 3, 6)));

        return testCases;
    }

    private List<LevelOrderTestCase<Integer>> getLevelOrderTraverseTestCases() {
        List<LevelOrderTestCase<Integer>> testCases = new ArrayList<>();

        // empty (root==null) tree
        testCases.add(new LevelOrderTestCase<>(null, new ArrayList<>()));

        //      1
        //     / \
        //    N   N
        testCases.add(new LevelOrderTestCase<>(new TreeNode<>(1), arraysToLists(new Integer[][]{{1}})));

        //      1
        //     / \
        //    2   N
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        testCases.add(new LevelOrderTestCase<>(root, arraysToLists(new Integer[][]{{1}, {2}})));

        //      1
        //     / \
        //    N   3
        root = new TreeNode<>(1);
        root.right = new TreeNode<>(3);
        testCases.add(new LevelOrderTestCase<>(root, arraysToLists(new Integer[][]{{1}, {3}})));

        //      1
        //     / \
        //    2   3
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        testCases.add(new LevelOrderTestCase<>(root, arraysToLists(new Integer[][]{{1}, {2, 3}})));

        //          1
        //         /
        //        2
        //       /
        //      4
        root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        testCases.add(new LevelOrderTestCase<>(root, arraysToLists(new Integer[][]{{1}, {2}, {3}})));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.right.right = new TreeNode<>(3);
        testCases.add(new LevelOrderTestCase<>(root, arraysToLists(new Integer[][]{{1}, {2}, {3}})));

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
        testCases.add(new LevelOrderTestCase<>(root, arraysToLists(new Integer[][]{{1}, {2, 3}, {4, 5, 6}})));

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
        testCases.add(new LevelOrderTestCase<>(root, arraysToLists(new Integer[][]{{1}, {2, 3}, {4, 5, 6}, {7, 8}, {9}})));

        return testCases;
    }

    private List<List<Integer>> arraysToLists(Integer[][] arrays) {
        List<List<Integer>> expects = new ArrayList<>();
        for (Integer[] array : arrays) {
            expects.add(Arrays.asList(array));
        }
        return expects;
    }
}