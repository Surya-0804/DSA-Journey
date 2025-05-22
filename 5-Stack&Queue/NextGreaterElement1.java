
/**
 * Problem: Next Greater Element I
 * 
 * Link: https://leetcode.com/problems/next-greater-element-i/description/
 * 
 * Given two distinct integer arrays nums1 and nums2 where nums1 is a subset of nums2,
 * for each element in nums1, find the next greater element in nums2.
 * If no such element exists, return -1 for that position.
 */

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    /**
     * Brute Force Approach
     * 
     * Time Complexity: O(n * m)
     * Space Complexity: O(n)
     */
    class BruteForceSolution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] answer = new int[nums1.length];

            for (int i = 0; i < nums1.length; i++) {

                boolean flag = false;
                answer[i] = -1;

                for (int j = 0; j < nums2.length; j++) {

                    if (nums2[j] == nums1[i]) {
                        flag = true;
                        continue;
                    }
                    if (flag && nums1[i] < nums2[j]) {
                        answer[i] = nums2[j];
                        break;
                    }
                }
            }
            return answer;
        }
    }

    /**
     * Optimized Solution using Stack and HashMap
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    class OptimizedSolution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            int[] answer = new int[nums1.length];
            HashMap<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = nums2.length - 1; i >= 0; i--) {

                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    map.put(nums2[i], -1);
                } else {
                    map.put(nums2[i], stack.peek());
                }

                stack.push(nums2[i]);
            }

            for (int i = 0; i < nums1.length; i++) {
                answer[i] = map.get(nums1[i]);
            }

            return answer;
        }
    }
}