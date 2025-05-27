
//Post-order traversal of a binary tree is a traversal method where the nodes are recursively visited in this order: left subtree, right subtree, and then the node itself. This is often used in scenarios where you need to process child nodes before their parent node, such as when deleting a tree or evaluating expressions in postfix notation.
// Post-order Traversal of a Binary Tree
// Given the root of a binary tree, return the postorder traversal of its nodes' values.
// Link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

// using two stacks
class TwoStacksSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        if (root == null)
            return answer;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null)
                stack1.push(temp.left);
            if (temp.right != null)
                stack1.push(temp.right);
        }
        while (!stack2.isEmpty()) {
            answer.add(stack2.pop().val);
        }
        return answer;
    }

}

// using one stacks
class OneStackSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        if (root == null)
            return answer;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode top = stack.peek();
            if (top.right != null && top.right != lastVisited) {
                current = top.right;
            } else {
                answer.add(top.val);
                lastVisited = top;
                stack.pop();
            }
        }
        return answer;
    }

}