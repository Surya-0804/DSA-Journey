
//Post-order traversal of a binary tree is a traversal method where the nodes are recursively visited in this order: left subtree, right subtree, and then the node itself. This is often used in scenarios where you need to process child nodes before their parent node, such as when deleting a tree or evaluating expressions in postfix notation.
// Post-order Traversal of a Binary Tree
// Given the root of a binary tree, return the postorder traversal of its nodes' values.
// Link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
// Time Complexity: O(n)
// Space Complexity: O(n)

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

class PostOrderTraversalSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        postOrder(root, answer);
        return answer;
    }

    private static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
