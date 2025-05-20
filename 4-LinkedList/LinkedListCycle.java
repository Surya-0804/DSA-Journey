//LinkedList cycle detection
// to find the loop in the linked list
//link: https://leetcode.com/problems/linked-list-cycle/description/

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * Brute-force approach to detect a cycle in a linked list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) {
                System.out.print(temp.val + " " + temp);
                return true;
            }
            map.put(temp, true);
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Optimized solution using Floyd’s Cycle Detection Algorithm (Tortoise and
 * Hare).
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class optimizedSolution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}