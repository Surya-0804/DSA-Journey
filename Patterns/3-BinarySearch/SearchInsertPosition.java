//Search Insert Position
// Problem: Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
// Time Complexity: O(log n)
// Space Complexity: O(1)
// Problem Link: https://leetcode.com/problems/search-insert-position/description/

class SearchInsertPositionSolution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int answer = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }
        return answer;
    }
}