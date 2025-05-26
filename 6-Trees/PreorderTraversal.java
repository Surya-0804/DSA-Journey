
// Preorder Traversal of a Binary Tree
// Given the root of a binary tree, return the preorder traversal of its nodes' values.
// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
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

class PreorderTraversalSolution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        preOrder(root, answer);
        return answer;
    }

    private static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
