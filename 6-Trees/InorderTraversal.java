
// Inorder Traversal of a Binary Tree
// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// link: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Time Complexity: O(n)
// Space Complexity: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class InorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> answer = new LinkedList<>();
        inOrder(root, answer);
        return answer;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}