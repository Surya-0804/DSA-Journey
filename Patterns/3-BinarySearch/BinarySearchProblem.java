// Binary Search Problem
// Problem: Given a sorted array of integers, find the index of a target value.
// Time Complexity: O(log n)
// Space Complexity: O(1)
// This code is a simple implementation of binary search algorithm in Java.
// Problem Link: https://www.leetcode.com/problems/binary-search/

// Iterative Solution
class IterativeSolution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // Prevents potential overflow
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}

// Recursive Solution
class RecursiveSolution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;

        // Prevents potential overflow
        int mid = low + (high - low) / 2;

        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return binarySearch(nums, target, low, mid - 1);
        else
            return binarySearch(nums, target, mid + 1, high);
    }
}
