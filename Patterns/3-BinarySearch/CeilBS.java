//Ceil Binary Search
// Problem: Given a sorted array of integers and a target value, find the smallest element in the array that is greater than or equal to the target value.
// Time Complexity: O(log n)
// Space Complexity: O(1)
// Problem Link: https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1

class CeilBSSolution {
    public int findCeil(int[] arr, int x) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}