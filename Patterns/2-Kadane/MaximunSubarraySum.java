// Maximum Subarray Sum
// Problem: https://leetcode.com/problems/maximum-subarray/

import java.util.Arrays;

/**
 * 🔴 Brute Force Approach
 * Time Complexity: O(n^3)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * - Try every possible subarray using 3 nested loops
 * - Compute the sum and update maximum found
 */
class BruteForceSolution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }
}

/**
 * 🟠 Better Approach
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * - Use 2 loops instead of 3 by keeping a running sum
 */
class BetterSolution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
}

/**
 * 🟢 Optimal Approach (Kadane's Algorithm)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * - Maintain a current sum and reset it to 0 if it goes negative
 * - Track the maximum sum encountered
 */
class KadaneSolution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxi = Math.max(maxi, sum);
            if (sum < 0)
                sum = 0;
        }
        return maxi;
    }
}

/**
 * 🟢 Kadane's Algorithm + Subarray Return
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding returned array)
 * 
 * Explanation:
 * - Track start and end indices along with the current sum
 * - Returns the actual subarray with the maximum sum
 */
class KadaneWithSubarraySolution {
    public int[] maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum == 0) {
                tempStart = i;
            }

            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return Arrays.copyOfRange(nums, start, end + 1);
    }
}
