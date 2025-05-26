//Level Order Traversal of a Binary Tree
// Level Order Traversal of a Binary Tree
// Given the root of a binary tree, return the level order traversal of its nodes' values.
//link:https://leetcode.com/problems/binary-tree-level-order-traversal/description/
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new LinkedList<>();
        if (root == null)
            return answer;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            answer.add(list);
        }
        return answer;
    }
}
