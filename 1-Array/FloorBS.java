//Floor Binary Search
// Problem: Given a sorted array of integers and a target value, find the largest element in the array that is less than or equal to the target value.
// Time Complexity: O(log n)
// Space Complexity: O(1)
// Problem Link: https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array/1

class FloorBSSolution {

    static int findFloor(int[] arr, int x) {
        // write code here
        int low = 0;
        int high = arr.length - 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
}
